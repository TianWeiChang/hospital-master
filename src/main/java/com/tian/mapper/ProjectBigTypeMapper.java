package com.tian.mapper;

import com.tian.entity.ProjectBigType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectBigTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectBigType record);

    ProjectBigType selectByPrimaryKey(Integer id);

    List<ProjectBigType> selectAll(ProjectBigType projectBigType);

    int updateByPrimaryKey(ProjectBigType record);

    Integer count(ProjectBigType record);
}