package com.tian.mapper;

import com.tian.entity.HospitalizationInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HospitalizationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HospitalizationInfo record);

    HospitalizationInfo selectByPrimaryKey(Integer id);

    List<HospitalizationInfo> selectAll();

    int updateByPrimaryKey(HospitalizationInfo record);
}