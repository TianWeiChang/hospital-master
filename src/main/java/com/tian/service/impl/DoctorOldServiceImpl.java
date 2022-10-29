package com.tian.service.impl;

import com.tian.entity.Departments;
import com.tian.entity.Doctor;
import com.tian.entity.RegisteredType;
import com.tian.mapper.DoctorMapper;
import com.tian.service.DoctorOldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DoctorOldServiceImpl implements DoctorOldService {
    @Resource
    private DoctorMapper doctorMapper;
    @Override
    public List<Doctor> doctorList(Doctor doctor) {
        return doctorMapper.doctorList(doctor);
    }

    @Override
    public int deleteDoctor(Integer doctorId) {
        return doctorMapper.deleteDoctor(doctorId);
    }

    @Override
    public int addDoctor(Doctor doctor) {
        return doctorMapper.addDoctor(doctor);
    }

    @Override
    public int editDoctor(Doctor doctor) {
        return doctorMapper.editDoctor(doctor);
    }

    @Override
    public List<Departments> findAllDepartments() {
        return doctorMapper.findAllDepartments();
    }

    @Override
    public List<RegisteredType> findAllRegisteredtype() {
        return doctorMapper.findAllRegisteredTypes();
    }

    @Override
    public int count(Doctor doctor) {
        return doctorMapper.count(doctor);
    }

    @Override
    public int checkCount(Integer doctorId) {
        return doctorMapper.checkCount(doctorId);
    }


}
