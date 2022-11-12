package com.tian.mapper;

import com.tian.entity.DoctorDuty;
import java.util.List;

public interface DoctorDutyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorDuty record);

    DoctorDuty selectByPrimaryKey(Integer id);

    List<DoctorDuty> selectAll();

    int updateByPrimaryKey(DoctorDuty record);
}