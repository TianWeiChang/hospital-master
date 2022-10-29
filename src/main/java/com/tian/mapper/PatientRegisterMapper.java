package com.tian.mapper;

import com.tian.entity.PatientRegister;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientRegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientRegister record);

    PatientRegister selectByPrimaryKey(Integer id);

    List<PatientRegister> selectAll(PatientRegister record);

    int updateByPrimaryKey(PatientRegister record);
}