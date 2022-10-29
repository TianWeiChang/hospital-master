package com.tian.mapper;

import com.tian.entity.DrugInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugInfoMapper {
    int deleteByPrimaryKey(DrugInfo drugInfo);

    int insert(DrugInfo record);

    DrugInfo selectByPrimaryKey(Integer id);

    List<DrugInfo> selectAll(DrugInfo drugInfo);

    int updateByPrimaryKey(DrugInfo record);

    int count(DrugInfo record);
}