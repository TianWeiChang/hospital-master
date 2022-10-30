package com.tian.service.impl;

import com.tian.entity.DepartmentInfo;
import com.tian.entity.DoctorInfo;
import com.tian.entity.RegisterTypeInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.DoctorInfoMapper;
import com.tian.mq.RabbitMqClient;
import com.tian.service.DepartmentInfoService;
import com.tian.service.DoctorInfoService;
import com.tian.service.RegisteredTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 医生信息操作实现类
 * @createTime 2022年10月19日
 */
@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {
    @Resource
    private DoctorInfoMapper doctorInfoMapper;
    @Resource
    private RabbitMqClient rabbitMQClient;
    @Resource
    private DepartmentInfoService departmentInfoService;
    @Resource
    private RegisteredTypeService registeredTypeService;

    @Override
    public List<DoctorInfo> doctorList(DoctorInfo doctor) {
        if (StringUtils.isEmpty(doctor.getDoctorName())) {
            doctor.setDoctorName(null);
        }
        List<DoctorInfo> listAll = doctorInfoMapper.selectAll(doctor);
        //页面字段展示现象转换
        if (CollectionUtils.isEmpty(listAll)) {
            return listAll;
        }

        //展示信息转换
        List<DepartmentInfo> departmentInfos = departmentInfoService.departmentList(null);
        Map<Integer, String> departmentInfoMap = departmentInfos.stream().collect(Collectors.toMap(DepartmentInfo::getId, DepartmentInfo::getDepartmentName));

        List<RegisterTypeInfo> registerTypeInfos = registeredTypeService.registeredTypeList(null);
        Map<Integer, String> registerTypeInfoMap = registerTypeInfos.stream().collect(Collectors.toMap(RegisterTypeInfo::getId, RegisterTypeInfo::getRegisterTypeName));

        for (DoctorInfo doctorInfo : listAll) {
            doctorInfo.setDepartmentName(departmentInfoMap.get(doctorInfo.getDepartmentId()));
            doctorInfo.setRegisterTypeName(registerTypeInfoMap.get(doctorInfo.getRegisterTypeId()));
        }
        return listAll;
    }
    @Override
    public List<DoctorInfo> doctorDepartment(DoctorInfo doctor) {
        if (StringUtils.isEmpty(doctor.getDoctorName())) {
            doctor.setDoctorName(null);
        }
        List<DoctorInfo> listAll = doctorInfoMapper.selectAll(doctor);
        //页面字段展示现象转换
        if (CollectionUtils.isEmpty(listAll)) {
            return listAll;
        }

        //展示信息转换
        List<DepartmentInfo> departmentInfos = departmentInfoService.departmentList(null);
        Map<Integer, String> departmentInfoMap = departmentInfos.stream().collect(Collectors.toMap(DepartmentInfo::getId, DepartmentInfo::getDepartmentName));

        List<RegisterTypeInfo> registerTypeInfos = registeredTypeService.registeredTypeList(null);
        Map<Integer, RegisterTypeInfo> registerTypeInfoMap = registerTypeInfos.stream().collect(Collectors.toMap(RegisterTypeInfo::getId, Function.identity()));

        for (DoctorInfo doctorInfo : listAll) {
            doctorInfo.setDepartmentName(departmentInfoMap.get(doctorInfo.getDepartmentId()));
            doctorInfo.setRegisterTypeName(registerTypeInfoMap.get(doctorInfo.getRegisterTypeId()).getRegisterTypeName());
            doctorInfo.setPrice(registerTypeInfoMap.get(doctorInfo.getRegisterTypeId()).getPrice());
        }
        return listAll;
    }
    @Override
    public String deleteDoctor(Integer doctorId) {
        return null;
    }

    @Override
    public String addDoctor(DoctorInfo doctor, User user) {
        int count = doctorInfoMapper.count(doctor);
        if (count > 0) {
            return doctor.getDoctorName() + "已存在";
        }
        doctor.setOperationUserId(user.getUserid());
        Date currDate = new Date();
        doctor.setCreateTime(currDate);
        doctor.setUpdateTime(currDate);
        doctor.setStatus(StatusEnum.normal.getCode());
        int flag = doctorInfoMapper.insert(doctor);
        if (flag == 1) {
            rabbitMQClient.doctorAddLog(doctor.toString());
            return "新增成功!";
        }
        return "新增失败!";
    }

    @Override
    public String editDoctor(DoctorInfo doctor, User user) {
        DoctorInfo oldDoctorInfo = doctorInfoMapper.selectByPrimaryKey(doctor.getId());
        oldDoctorInfo.setOperationUserId(user.getUserid());
        oldDoctorInfo.setUpdateTime(new Date());
        oldDoctorInfo.setDoctorName(doctor.getDoctorName());
        oldDoctorInfo.setDepartmentId(doctor.getDepartmentId());
        oldDoctorInfo.setTypeId(doctor.getTypeId());
        oldDoctorInfo.setRegisterTypeId(doctor.getRegisterTypeId());
        int flag = doctorInfoMapper.updateByPrimaryKey(oldDoctorInfo);
        if (flag == 1) {
            return "修改成功!";
        }
        return "修改失败!";
    }

    @Override
    public int count(DoctorInfo doctor) {
        return 0;
    }

    @Override
    public boolean checkCount(Integer doctorId) {
        // TODO: 2022/10/19 通过医生ID查询病人挂号信息
        return false;
    }

}
