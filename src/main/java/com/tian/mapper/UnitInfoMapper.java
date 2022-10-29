package com.tian.mapper;

import com.tian.entity.UnitInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnitInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnitInfo record);

    UnitInfo selectByPrimaryKey(Integer id);

    List<UnitInfo> selectAll(UnitInfo unitInfo);

    int updateByPrimaryKey(UnitInfo record);

    int count(UnitInfo record);
}