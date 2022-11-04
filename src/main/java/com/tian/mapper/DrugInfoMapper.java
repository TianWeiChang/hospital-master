package com.tian.mapper;

import com.tian.dto.DrugInfoDto;
import com.tian.entity.DrugInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DrugInfo record);

    DrugInfo selectByPrimaryKey(Integer id);

    List<DrugInfo> selectList(DrugInfo drugInfo);

    List<DrugInfoDto> selectPage(DrugInfo drugInfo);

    int updateByPrimaryKey(DrugInfo record);

    int count(DrugInfo record);
}