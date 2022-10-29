package com.tian.mapper;

import com.tian.entity.OutpatientDepartmentChargeProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutpatientDepartmentChargeProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OutpatientDepartmentChargeProject record);

    OutpatientDepartmentChargeProject selectByPrimaryKey(Integer id);

    List<OutpatientDepartmentChargeProject> selectAll(OutpatientDepartmentChargeProject outpatientDepartmentChargeProject);

    int updateByPrimaryKey(OutpatientDepartmentChargeProject record);

    int count(OutpatientDepartmentChargeProject outpatientDepartmentChargeProject);
}