package com.tian.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.tian.config.MyDefaultAlipayClient;
import com.tian.config.RedisConfig;
import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientRegisterReq;
import com.tian.entity.*;
import com.tian.enums.PayStatusEnum;
import com.tian.mapper.*;
import com.tian.service.DepartmentInfoService;
import com.tian.service.OuterPatientRegisterService;
import com.tian.service.PatientRegisterService;
import com.tian.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 18:26
 * <p>
 * 外网挂号+在线支付
 */
@Slf4j
@Service
public class OuterPatientRegisterServiceImpl implements OuterPatientRegisterService {
    @Resource
    private PatientRegisterService patientRegisterService;
    @Resource
    private RedisConfig redisConfig;
    @Resource
    private DepartmentInfoService departmentInfoService;
    @Resource
    private RegisterTypeInfoMapper registerTypeInfoMapper;
    @Resource
    private DoctorInfoMapper doctorInfoMapper;
    @Resource
    private DoctorDutyMapper doctorDutyMapper;
    @Resource
    private DoctorLeaveMapper doctorLeaveMapper;
    @Resource
    private AlipayClient alipayClient;
    @Resource
    private MyDefaultAlipayClient myDefaultAlipayClient;
    @Resource
    private PatientRegisterMapper patientRegisterMapper;
    @Resource
    private DoctorRegisterTimeSlotMapper doctorRegisterTimeSlotMapper;
    @Resource
    private RegisterTimeSlotMapper registerTimeSlotMapper;

    private static final String REGISTER_PAY_ORDER_PRE = "REGISTER_PAY_ORDER_";

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResult register(OuterPatientRegisterReq outerPatientRegisterReq) {
        OuterPatientRegister outerPatientRegister = JSON.parseObject(redisConfig.get(outerPatientRegisterReq.getToken()), OuterPatientRegister.class);
        PatientRegisterParamsDTO patientRegister = new PatientRegisterParamsDTO();
        patientRegister.setPatientName(outerPatientRegisterReq.getPatientName());
        patientRegister.setDepartmentId(outerPatientRegisterReq.getDepartmentId());
        patientRegister.setRegisterTypeId(outerPatientRegisterReq.getRegisterTypeId());
        patientRegister.setPhone(outerPatientRegister.getPhone());
        patientRegister.setDoctorId(outerPatientRegisterReq.getDoctorId());
        patientRegister.setCarId(outerPatientRegisterReq.getCardId());
        patientRegister.setAge(outerPatientRegisterReq.getAge());
        patientRegister.setGender(outerPatientRegisterReq.getGender());
        int flag = patientRegisterService.add(patientRegister);
        if (flag == 1) {
            DoctorRegisterTimeSlot doctorRegisterTimeSlot = doctorRegisterTimeSlotMapper.selectByPrimaryKey(outerPatientRegisterReq.getDoctorRegisterTimeSlotId());
            doctorRegisterTimeSlot.setRegisterTotal(doctorRegisterTimeSlot.getRegisterTotal() + 1);
            doctorRegisterTimeSlotMapper.updateByPrimaryKey(doctorRegisterTimeSlot);
            return CommonResult.success("挂号成功");
        }
        return CommonResult.failed("挂号失败");
    }

    @Override
    public CommonResult departmentList(OuterPatientRegisterReq outerPatientRegisterReq) {
        List<DepartmentInfo> departmentInfos = departmentInfoService.departmentList(null);
        if (CollectionUtils.isEmpty(departmentInfos)) {
            return CommonResult.failed("科室数据不存在");
        }
        return CommonResult.success(departmentInfos);
    }

    @Override
    public CommonResult doctorList(OuterPatientRegisterReq outerPatientRegisterReq) {
        int departmentId = outerPatientRegisterReq.getDepartmentId();
        int registerTypeId = outerPatientRegisterReq.getRegisterTypeId();

        //判断当前是不是周末
        boolean weekend = DateUtil.isWeekend();
        List<DoctorLeave> doctorLeaveList = null;
        List<Integer> doctorIdList = null;

        if (!weekend) {
            //查值班表
            DoctorDuty doctorDuty = new DoctorDuty();
            doctorDuty.setDepartmentId(departmentId);
            doctorDuty.setRegisterTypeId(registerTypeId);
            List<DoctorDuty> doctorDutyList = doctorDutyMapper.selectAll(doctorDuty);
            if (CollectionUtils.isEmpty(doctorDutyList)) {
                return CommonResult.failed("没有人值班");
            }

            doctorIdList = new ArrayList<>();
            for (DoctorDuty d : doctorDutyList) {
                doctorIdList.add(d.getDoctorId());
            }
            //再查请假表
            doctorLeaveList = doctorLeaveMapper.selectByIdList(doctorIdList);
        } else {
            DoctorLeave doctorLeave = new DoctorLeave();
            doctorLeave.setDepartmentId(departmentId);
            doctorLeave.setRegisterTypeId(registerTypeId);
            doctorLeaveList = doctorLeaveMapper.selectAll(doctorLeave);
        }

        //去除 已经请假的
        if (!CollectionUtils.isEmpty(doctorLeaveList)) {
            Map<Integer, DoctorLeave> maps = doctorLeaveList.stream().collect(Collectors.toMap(DoctorLeave::getDoctorId, Function.identity()));
            Iterator<Integer> integerIterator = doctorIdList.iterator();
            while (integerIterator.hasNext()) {
                Integer id = integerIterator.next();
                if (maps.get(id) != null) {
                    doctorIdList.remove(id);
                }
            }
        }
        //最终展示给患者看的某科室下的 某挂号类型下的  所以医生
        List<DoctorInfo> doctorList = doctorInfoMapper.selectByIdList(doctorIdList);
        if (CollectionUtils.isEmpty(doctorList)) {
            return CommonResult.failed("没有医生不存在");
        }
        return CommonResult.success(doctorList);
    }

    @Override
    public CommonResult registerTypeList(OuterPatientRegisterReq outerPatientRegisterReq) {
        List<RegisterTypeInfo> registerTypeInfoList = registerTypeInfoMapper.selectAll(null);
        if (CollectionUtils.isEmpty(registerTypeInfoList)) {
            return CommonResult.failed("挂号类型数据不存在");
        }
        return CommonResult.success(registerTypeInfoList);
    }

    /**
     * 前端处理：
     * 如果已约人数和最多人数一样了，显示已约满
     * 如果已约人数小于最多人数，则用最多人数 - 已约人数 = 剩余可约
     */
    @Override
    public CommonResult doctorTimeSlotList(Integer doctorId, Date registerDate, Integer timeSlot) {
        RegisterTimeSlot registerTimeSlot = new RegisterTimeSlot();
        registerTimeSlot.setTimeSlot(timeSlot);
        List<RegisterTimeSlot> registerTimeSlotList = registerTimeSlotMapper.selectAll(registerTimeSlot);
        if (CollectionUtils.isEmpty(registerTimeSlotList)) {
            return CommonResult.failed("timeSlot 参数有误");
        }
        Integer registerTimeSlotId = registerTimeSlotList.get(0).getId();

        DoctorRegisterTimeSlot doctorRegisterTimeSlot = new DoctorRegisterTimeSlot();
        doctorRegisterTimeSlot.setDoctorId(doctorId);
        doctorRegisterTimeSlot.setRegisterDate(registerDate);
        doctorRegisterTimeSlot.setRegisterTimeSlotId(registerTimeSlotId);
        List<DoctorRegisterTimeSlot> doctorRegisterTimeSlotList = doctorRegisterTimeSlotMapper.selectAll(doctorRegisterTimeSlot);
        if (CollectionUtils.isEmpty(doctorRegisterTimeSlotList)) {
            // TODO: 2022/11/14 这里还有一种处理方式，就是定时任务每周之星一次，把医生、日期、时间段 插入数据库表中
            //证明还没有约过
            doctorRegisterTimeSlot.setRegisterTotal(0);
            doctorRegisterTimeSlotMapper.insert(doctorRegisterTimeSlot);
            RegisterTimeVO registerTimeVO = new RegisterTimeVO();
            registerTimeVO.setRegisterDate(DateUtil.format(doctorRegisterTimeSlot.getRegisterDate(), DateUtil.DATEFORMATDAY));
            registerTimeVO.setRegisterTotal(doctorRegisterTimeSlot.getRegisterTotal());
            registerTimeVO.setMax(registerTimeSlotList.get(0).getMax());
            registerTimeVO.setDoctorRegisterTimeSlotId(doctorRegisterTimeSlot.getId());
            return CommonResult.success(registerTimeVO);
        }
        DoctorRegisterTimeSlot doctorRegisterTimeSlot1 = doctorRegisterTimeSlotList.get(0);

        RegisterTimeVO registerTimeVO = new RegisterTimeVO();
        registerTimeVO.setRegisterDate(DateUtil.format(doctorRegisterTimeSlot1.getRegisterDate(), DateUtil.DATEFORMATDAY));
        registerTimeVO.setRegisterTotal(doctorRegisterTimeSlot1.getRegisterTotal());
        registerTimeVO.setMax(registerTimeSlotList.get(0).getMax());
        registerTimeVO.setDoctorRegisterTimeSlotId(doctorRegisterTimeSlot1.getId());
        return CommonResult.success(registerTimeVO);
    }

    @Override
    public CommonResult<String> preCreateOrder(Integer id) throws AlipayApiException {
        PatientRegister patientRegister = patientRegisterMapper.selectByPrimaryKey(id);
        if (patientRegister == null) {
            return CommonResult.failed("获取挂号信息失败");
        }
        RegisterTypeInfo registerTypeInfo = registerTypeInfoMapper.selectByPrimaryKey(patientRegister.getRegisterTypeId());
        int totalAmount = registerTypeInfo.getPrice();
        String tradeNo = REGISTER_PAY_ORDER_PRE + id;
        log.info("订单号：{}", tradeNo);

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        JSONObject params = new JSONObject();
        params.put("out_trade_no", tradeNo);
        params.put("total_amount", totalAmount);
        params.put("subject", "挂号收费");
        params.put("body", "详情");
        params.put("store_id", "NJ_2031");
        request.setBizContent(params.toString());
        request.setNotifyUrl(myDefaultAlipayClient.getNotifyUrl());

        AlipayTradePrecreateResponse responseData = null;
        try {
            responseData = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("获取支付宝支付二维码失败", e);
        }
        if (responseData == null) {
            log.error("获取支付宝支付二维码失败, 返回参数为空");
            return CommonResult.failed("获取支付宝支付二维码失败, 返回参数为空");
        }
        patientRegister.setPayStatus(PayStatusEnum.WAIT_BUYER_PAY.getCode());
        patientRegister.setUpdateTime(new Date());
        patientRegisterMapper.updateByPrimaryKey(patientRegister);
        String respBody = responseData.getBody();
        log.info("response:{}", respBody);
        return CommonResult.success(respBody);
    }

    @Override
    public CommonResult payNotify(String tradeNo, String payStatus) {
        Integer id = Integer.valueOf(tradeNo.replaceAll(REGISTER_PAY_ORDER_PRE, ""));
        PatientRegister patientRegister = patientRegisterMapper.selectByPrimaryKey(id);
        if (patientRegister == null) {
            return CommonResult.failed("获取挂号信息失败");
        }
        //根据支付宝返回状态 修改 本地挂号单 付款状态
        PayStatusEnum payStatusEnum = PayStatusEnum.valueOfName(payStatus);
        if (payStatusEnum == null) {
            payStatusEnum = PayStatusEnum.INIT;
        }
        patientRegister.setPayStatus(payStatusEnum.getCode());
        int flag = patientRegisterMapper.updateByPrimaryKey(patientRegister);
        if (flag == 1) {
            return CommonResult.success("成功");
        }
        return CommonResult.success("失败");
    }

    @Override
    public void payOrderQuery() {
        int startIndex = 0;
        int pageSize = 50;
        //-10表示 时间往前移动，16:20:00---> 16:10:00
        //也就是查10分之前的 状态还是预支付状态的挂号单
        Date updateTime = DateUtil.addMinute(-1);
        int count = patientRegisterMapper.selectList4OrderQueryCount(updateTime);
        if (count == 0) {
            log.info("不存在预支付状态的挂号单");
        }
        if (count < pageSize) {
            queryOrderStatus(startIndex, updateTime, count);
        } else {
            int length = count / pageSize;
            //count=21 pageSize=10---
            // 1:startIndex=0,pageSize=10
            // 2:startIndex=10,pageSize=10
            // 3:startIndex=20,pageSize=10
            //每次只查 50 条数据 （不建议太多了）
            for (int i = 0; i < length; i++) {
                queryOrderStatus(startIndex, updateTime, count);
                startIndex = startIndex + pageSize;
            }
        }
    }

    private void queryOrderStatus(int startIndex, Date updateTime, int count) {
        List<PatientRegister> patientRegisterList = patientRegisterMapper.selectList4OrderQuery(updateTime, startIndex, count);
        for (PatientRegister patientRegister : patientRegisterList) {
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            JSONObject params = new JSONObject();
            params.put("out_trade_no", REGISTER_PAY_ORDER_PRE + patientRegister.getId());
            request.setBizContent(params.toString());
            request.setNotifyUrl(myDefaultAlipayClient.getNotifyUrl());

            AlipayTradeQueryResponse responseData;
            try {
                responseData = alipayClient.execute(request);
            } catch (AlipayApiException e) {
                log.error("查询订单状态失败", e);
                continue;
            }
            if (responseData == null) {
                log.error("查询订单状态失败失败, 返回参数为空");
                return;
            }
            String payStatus = responseData.getTradeStatus();
            String tradeNo = responseData.getOutTradeNo();
            this.payNotify(tradeNo, payStatus);
        }
    }
}
