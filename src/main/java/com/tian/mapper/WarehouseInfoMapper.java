package com.tian.mapper;

import com.tian.entity.WarehouseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseInfo record);

    WarehouseInfo selectByPrimaryKey(Integer id);

    List<WarehouseInfo> selectAll(WarehouseInfo warehouseInfo);

    int updateByPrimaryKey(WarehouseInfo record);

    int count(WarehouseInfo record);
}