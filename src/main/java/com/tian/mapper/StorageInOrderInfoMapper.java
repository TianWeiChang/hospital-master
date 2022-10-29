package com.tian.mapper;

import com.tian.entity.StorageInOrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageInOrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorageInOrderInfo record);

    StorageInOrderInfo selectByPrimaryKey(Integer id);

    List<StorageInOrderInfo> selectAll(StorageInOrderInfo storageInOrderInfo);

    int updateByPrimaryKey(StorageInOrderInfo record);

    Integer storageSum(StorageInOrderInfo record);
}