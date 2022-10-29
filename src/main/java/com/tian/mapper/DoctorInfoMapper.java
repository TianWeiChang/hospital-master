package com.tian.mapper;

import com.tian.entity.DoctorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorInfo record);

    DoctorInfo selectByPrimaryKey(Integer id);

    List<DoctorInfo> selectAll(DoctorInfo doctor);

    List<DoctorInfo> selectByIdList(List<Integer> ids);

    int updateByPrimaryKey(DoctorInfo record);

    int count(DoctorInfo record);
}