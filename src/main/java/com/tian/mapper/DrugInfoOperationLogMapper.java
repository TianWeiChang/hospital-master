package com.tian.mapper;

import com.tian.entity.DrugInfoOperationLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugInfoOperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DrugInfoOperationLog record);

    DrugInfoOperationLog selectByPrimaryKey(Integer id);

    List<DrugInfoOperationLog> selectAll();

    int updateByPrimaryKey(DrugInfoOperationLog record);
}