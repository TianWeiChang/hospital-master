package com.tian.mapper;

import com.tian.entity.DepartmentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentInfo record);

    DepartmentInfo selectByPrimaryKey(Integer id);

    List<DepartmentInfo> selectAll(DepartmentInfo departments);

    int updateByPrimaryKey(DepartmentInfo record);

    int count(DepartmentInfo departments);
}