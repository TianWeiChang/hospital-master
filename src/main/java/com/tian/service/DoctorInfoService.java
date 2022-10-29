package com.tian.service;

import com.tian.entity.*;

import java.util.List;

public interface DoctorInfoService {
    /**
     * 医生信息列表
     */
    List<DoctorInfo> doctorList(DoctorInfo doctor);

    List<DoctorInfo> doctorDepartment(DoctorInfo doctor);

    /**
     * 删除医生信息
     */
    String deleteDoctor(Integer doctorId);

    /**
     * 新增医生信息
     */
    String addDoctor(DoctorInfo doctor, User user);

    /**
     * 修改医生信息
     */
    String editDoctor(DoctorInfo doctor, User user);

    /**
     * 医生人数
     */
    int count(DoctorInfo doctor);

    /**
     * 判断该医生是否还有病人
     */
    boolean checkCount(Integer doctorId);
}
