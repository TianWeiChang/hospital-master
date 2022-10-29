package com.tian.mapper;

import com.tian.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

import com.tian.entity.Departments;
import com.tian.entity.RegisteredType;

import java.util.List;
/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 医生信息操作
 * @createTime 2022年10月12日 10:22
 */
@Mapper
public interface DoctorMapper {

    List<Doctor> doctorList(Doctor doctor);

    int deleteDoctor(Integer doctorId);

    int addDoctor(Doctor doctor);

    int editDoctor(Doctor doctor);

    List<Departments> findAllDepartments();

    List<RegisteredType> findAllRegisteredTypes();

    int count(Doctor doctor);
    /*
     * 判断该医生是否还有病人
     * */
    int checkCount(Integer doctorId);
}
