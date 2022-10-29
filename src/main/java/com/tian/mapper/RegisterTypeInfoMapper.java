package com.tian.mapper;

import com.tian.entity.RegisterTypeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RegisterTypeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegisterTypeInfo record);

    RegisterTypeInfo selectByPrimaryKey(Integer id);

    List<RegisterTypeInfo> selectAll(RegisterTypeInfo record);

    int updateByPrimaryKey(RegisterTypeInfo record);

    int count(RegisterTypeInfo record);
}