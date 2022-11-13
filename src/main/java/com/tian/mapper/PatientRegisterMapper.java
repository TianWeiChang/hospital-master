package com.tian.mapper;

import com.tian.entity.PatientRegister;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PatientRegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientRegister record);

    PatientRegister selectByPrimaryKey(Integer id);

    List<PatientRegister> selectAll(PatientRegister record);

    List<PatientRegister> selectList4OrderQuery(@Param("updateTime") Date updateTime, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    int updateByPrimaryKey(PatientRegister record);

    int selectList4OrderQueryCount(@Param("updateTime") Date updateTime);
}