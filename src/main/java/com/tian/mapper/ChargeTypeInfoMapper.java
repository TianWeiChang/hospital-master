package com.tian.mapper;

import com.tian.entity.ChargeTypeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChargeTypeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChargeTypeInfo record);

    ChargeTypeInfo selectByPrimaryKey(Integer id);

    List<ChargeTypeInfo> selectAll(ChargeTypeInfo chargeTypeInfo);

    int updateByPrimaryKey(ChargeTypeInfo record);

    Integer count(ChargeTypeInfo chargeTypeInfo);
}