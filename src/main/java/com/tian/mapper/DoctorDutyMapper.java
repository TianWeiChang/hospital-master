package com.tian.mapper;

import com.tian.entity.DoctorDuty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorDutyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorDuty record);

    DoctorDuty selectByPrimaryKey(Integer id);

    List<DoctorDuty> selectAll(DoctorDuty doctorDuty);

    int updateByPrimaryKey(DoctorDuty record);
}