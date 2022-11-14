package com.tian.mapper;

import com.tian.entity.RegisterTimeSlot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterTimeSlotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegisterTimeSlot record);

    RegisterTimeSlot selectByPrimaryKey(Integer id);

    List<RegisterTimeSlot> selectAll(RegisterTimeSlot registerTimeSlot);

    int updateByPrimaryKey(RegisterTimeSlot record);
}