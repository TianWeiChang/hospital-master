package com.tian.mapper;

import com.tian.entity.OperatorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperatorInfoMapper {
    int deleteByPrimaryKey(OperatorInfo record);

    int insert(OperatorInfo record);

    OperatorInfo selectByPrimaryKey(Integer id);

    List<OperatorInfo> selectAll(OperatorInfo operatorInfo);

    int updateByPrimaryKey(OperatorInfo record);

    int count(OperatorInfo record);
}