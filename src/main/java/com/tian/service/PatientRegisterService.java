package com.tian.service;

import com.tian.entity.PatientRegister;
import com.tian.entity.PatientRegisterParamsDTO;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月21日 11:08
 * 病人挂号
 */
public interface PatientRegisterService {
    List<PatientRegisterParamsDTO> list(PatientRegisterParamsDTO patientRegister);

    int  add(PatientRegisterParamsDTO patientRegister);

    PatientRegister selectById(Integer id);

    int addPatientPathogeny(PatientRegisterParamsDTO registerParamsDTO,User user);

    int addInspectInstructions(PatientRegisterParamsDTO registerParamsDTO,User user);
}
