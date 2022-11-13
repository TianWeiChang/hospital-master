package com.tian.mapper;

import com.tian.entity.DoctorLeave;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorLeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorLeave record);

    DoctorLeave selectByPrimaryKey(Integer id);

    List<DoctorLeave> selectAll(DoctorLeave doctorLeave);

    int updateByPrimaryKey(DoctorLeave record);

    List<DoctorLeave> selectByIdList(List<Integer> idList);
}