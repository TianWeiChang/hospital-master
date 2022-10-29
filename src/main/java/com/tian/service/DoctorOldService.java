package com.tian.service;

import com.tian.entity.Departments;
import com.tian.entity.Doctor;
import com.tian.entity.RegisteredType;

import java.util.List;

public interface DoctorOldService {
    /*
     * 医生的增删改查
     * */
    List<Doctor> doctorList(Doctor doctor);
    int deleteDoctor(Integer doctorId);
    int addDoctor(Doctor doctor);
    int editDoctor(Doctor doctor);
    List<Departments> findAllDepartments();
    List<RegisteredType>findAllRegisteredtype();
    int count(Doctor doctor);
    /*
     * 判断该医生是否还有病人
     * */
    int checkCount(Integer doctorId);
}
