package com.tian.mapper;

import com.tian.entity.StorageInOrderInfo;
import com.tian.entity.StorageInOrderInfoRespDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StorageInOrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorageInOrderInfo record);

    StorageInOrderInfo selectByPrimaryKey(Integer id);

    List<StorageInOrderInfo> selectAll(StorageInOrderInfo record);

    List<StorageInOrderInfoRespDto> selectListPage(@Param("drugName") String  drugName);

    int updateByPrimaryKey(StorageInOrderInfo record);

    int storageSum(@Param("drugInfoId") Integer drugInfoId);
}