package com.tian.mapper;

import com.tian.entity.BedInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BedInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BedInfo record);

    BedInfo selectByPrimaryKey(Integer id);

    List<BedInfo> selectAll(BedInfo bedInfo);

    int updateByPrimaryKey(BedInfo record);

    Integer count(BedInfo record);
}