package com.tian.mapper;

import com.tian.entity.DoctorLeave;
import java.util.List;

public interface DoctorLeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorLeave record);

    DoctorLeave selectByPrimaryKey(Integer id);

    List<DoctorLeave> selectAll();

    int updateByPrimaryKey(DoctorLeave record);
}