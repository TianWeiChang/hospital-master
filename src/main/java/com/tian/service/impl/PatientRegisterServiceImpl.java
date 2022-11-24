package com.tian.service.impl;

import com.tian.entity.*;
import com.tian.enums.GenderEnum;
import com.tian.enums.StatusEnum;
import com.tian.mapper.*;
import com.tian.service.PatientRegisterService;
import com.tian.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月21日 11:09
 */
@Service
public class PatientRegisterServiceImpl implements PatientRegisterService {

    @Resource
    private PatientRegisterMapper patientRegisterMapper;
    @Resource
    private PatientInfoMapper patientInfoMapper;
    @Resource
    private DoctorInfoMapper doctorInfoMapper;
    @Resource
    private RegisterTypeInfoMapper registerTypeInfoMapper;
    @Resource
    private DepartmentInfoMapper departmentInfoMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private PrescriptionPricingMapper prescriptionPricingMapper;

    @Override
    public List<PatientRegisterParamsDTO> list(PatientRegisterParamsDTO patientRegister) {
        PatientRegister record = new PatientRegister();
        record.setDate(patientRegister.getDate());
        record.setPatientName(patientRegister.getPatientName());
        List<PatientRegister> patientRegisterList = patientRegisterMapper.selectAll(record);
        List<PatientRegisterParamsDTO> patientRegisterParamsDTOArrayList = new ArrayList<>();
        if (CollectionUtils.isEmpty(patientRegisterList)) {
            return patientRegisterParamsDTOArrayList;
        }

        List<Integer> patientIds = new ArrayList<>();
        List<Integer> doctorIds = new ArrayList<>();
        for (PatientRegister item : patientRegisterList) {
            patientIds.add(item.getPatientId());
            doctorIds.add(item.getDoctorId());
        }
        //病人基本信息
        List<PatientInfo> patientInfoList = patientInfoMapper.selectByIdList(patientIds);
        Map<Integer, PatientInfo> patientInfoListMap = patientInfoList.stream().collect(Collectors.toMap(PatientInfo::getId, Function.identity()));
        //医生基本信息
        List<DoctorInfo> doctorInfoList = doctorInfoMapper.selectByIdList(doctorIds);
        Map<Integer, DoctorInfo> doctorInfoListMap = doctorInfoList.stream().collect(Collectors.toMap(DoctorInfo::getId, Function.identity()));
        //科室信息
        // TODO: 2022/10/21 可以优化把这种不怎么变动的信息放到redis中
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectAll(null);
        Map<Integer, DepartmentInfo> departmentInfosMap = departmentInfos.stream().collect(Collectors.toMap(DepartmentInfo::getId, Function.identity()));

        //挂号类型
        List<RegisterTypeInfo> registerTypeInfoList = registerTypeInfoMapper.selectAll(null);
        Map<Integer, RegisterTypeInfo> registerTypeInfoListMap = registerTypeInfoList.stream().collect(Collectors.toMap(RegisterTypeInfo::getId, Function.identity()));

        //数据展示转换
        for (PatientRegister p : patientRegisterList) {
            PatientRegisterParamsDTO registerParamsDTO = new PatientRegisterParamsDTO();
            PatientInfo patientInfo = patientInfoListMap.get(p.getPatientId());

            registerParamsDTO.setGenderName(GenderEnum.valueOfCode(patientInfo.getGender()).getDesc());
            registerParamsDTO.setGender(patientInfo.getGender());
            registerParamsDTO.setAge(patientInfo.getAge());
            registerParamsDTO.setPatientName(patientInfo.getPatientName());
            registerParamsDTO.setPhone(patientInfo.getPhone());
            registerParamsDTO.setCarId(patientInfo.getCarId());

            DoctorInfo doctorInfo = doctorInfoListMap.get(p.getDoctorId());
            RegisterTypeInfo registerTypeInfo = registerTypeInfoListMap.get(doctorInfo.getRegisterTypeId());

            registerParamsDTO.setDoctorName(doctorInfo.getDoctorName());
            registerParamsDTO.setPrice(registerTypeInfo.getPrice());
            registerParamsDTO.setRegisterTypeName(registerTypeInfo.getRegisterTypeName());

            DepartmentInfo departmentInfo = departmentInfosMap.get(p.getDepartmentId());
            registerParamsDTO.setDepartmentName(departmentInfo.getDepartmentName());

            String createTimeStr = DateUtil.format(p.getCreateTime(), DateUtil.DATEFORMATSECOND);
            registerParamsDTO.setCreateTimeStr(createTimeStr);

            //操作人员
//            registerParamsDTO.setOperationUser(userMapper.selectUserById(p.getOperationUserId()).getRealname());

            registerParamsDTO.setId(p.getId());

            registerParamsDTO.setPathogeny(p.getPathogeny());

            patientRegisterParamsDTOArrayList.add(registerParamsDTO);
        }

        return patientRegisterParamsDTOArrayList;
    }

    /**
     * 事务处理
     * 必须两个表都插入成功，或者两个都不成功
     */
    @Transactional("aaaaaaa")
    @Override
    public int add(PatientRegisterParamsDTO patientRegisterParamsDTO) {
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.setCarId(patientRegisterParamsDTO.getCarId());
        PatientInfo patientInfoOld = patientInfoMapper.selectByCardId(patientInfo);
        Date currDate = new Date();
        Integer patientId;
        if (patientInfoOld == null) {
            //第一次来挂号
            patientInfo.setPhone(patientRegisterParamsDTO.getPhone());
            patientInfo.setAge(patientRegisterParamsDTO.getAge());
            patientInfo.setGender(patientRegisterParamsDTO.getGender());
            patientInfo.setPatientName(patientRegisterParamsDTO.getPatientName());
            patientInfo.setUpdateTime(currDate);
            patientInfo.setCreateTime(currDate);
            patientInfoMapper.insert(patientInfo);
            patientId = patientInfo.getId();
        } else if (!patientInfoOld.getPhone().equals(patientInfo.getPhone())) {
            //手机号变更
            patientInfoOld.setPhone(patientInfo.getPhone());
            patientInfoOld.setUpdateTime(currDate);
            patientInfoMapper.updateByPrimaryKey(patientInfoOld);
            patientId = patientInfoOld.getId();
            // TODO: 2022/10/21 同MQ记录变更历史
        } else {
            patientId = patientInfoOld.getId();
        }
        PatientRegister patientRegister = new PatientRegister();
        patientRegister.setDepartmentId(patientRegisterParamsDTO.getDepartmentId());
        patientRegister.setDoctorId(patientRegisterParamsDTO.getDoctorId());
        patientRegister.setRegisterTypeId(patientRegisterParamsDTO.getRegisterTypeId());

        patientRegister.setUpdateTime(currDate);
        patientRegister.setCreateTime(currDate);
        patientRegister.setPatientId(patientId);
        patientRegister.setPatientName(patientRegisterParamsDTO.getPatientName());
        patientRegister.setStatus(StatusEnum.normal.getCode());
        return patientRegisterMapper.insert(patientRegister);
    }

    @Override
    public PatientRegister selectById(Integer id) {
        return patientRegisterMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addPatientPathogeny(PatientRegisterParamsDTO registerParamsDTO, User user) {
        PatientRegister patientRegister = patientRegisterMapper.selectByPrimaryKey(registerParamsDTO.getId());
        patientRegister.setPathogeny(registerParamsDTO.getPathogeny());
        patientRegister.setUpdateTime(new Date());
        patientRegister.setOperationUserId(user.getUserid());
        int flag = patientRegisterMapper.updateByPrimaryKey(patientRegister);
        if (flag == 1) {
            // TODO: 2022/10/23 消息队列记录当前医生给病人看病写下的病因
        }
        return flag;
    }

    @Override
    public int addInspectInstructions(PatientRegisterParamsDTO registerParamsDTO, User user) {
        PatientRegister patientRegister = patientRegisterMapper.selectByPrimaryKey(registerParamsDTO.getId());
        // 可删
        patientRegister.setInspectInstructions(patientRegister.getInspectInstructions() + " | " + registerParamsDTO.getInspectInstructions());
        patientRegister.setUpdateTime(new Date());
        patientRegister.setOperationUserId(user.getUserid());
        int flag = patientRegisterMapper.updateByPrimaryKey(patientRegister);
        if (flag != 1) {
            // TODO: 2022/10/27 更新失败
            return flag;
        }
        Integer prescriptionPricingId = registerParamsDTO.getPrescriptionPricingId();
        PrescriptionPricing prescriptionPricing = prescriptionPricingMapper.selectByPrimaryKey(prescriptionPricingId);

        prescriptionPricing.setInspectInstructions(registerParamsDTO.getInspectInstructions());
        prescriptionPricing.setUpdateTime(new Date());
        prescriptionPricing.setOperationUserId(user.getUserid());
        prescriptionPricing.setInspectStatus(StatusEnum.abnormal.getCode());
        flag = prescriptionPricingMapper.updateByPrimaryKey(prescriptionPricing);
        if (flag == 1) {
            // TODO: 2022/10/23 消息队列记录当前医生给病人看病写下的病因
        }
        return flag;
    }
}
