package com.tian.service.impl;

import com.alibaba.fastjson.JSON;
import com.tian.config.RedisConfig;
import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientRegisterReq;
import com.tian.entity.OuterPatientRegister;
import com.tian.entity.PatientRegisterParamsDTO;
import com.tian.service.OuterPatientRegisterService;
import com.tian.service.PatientRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 18:26
 * <p>
 * 外网挂号
 */
@Service
public class OuterPatientRegisterServiceImpl implements OuterPatientRegisterService {
    @Resource
    private PatientRegisterService patientRegisterService;
    @Resource
    private RedisConfig redisConfig;

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
            return CommonResult.success("挂号成功");
        }
        return CommonResult.failed("挂号失败");
    }
}
