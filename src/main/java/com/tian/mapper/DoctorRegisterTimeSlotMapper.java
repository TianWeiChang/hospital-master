package com.tian.mapper;

import com.tian.entity.DoctorRegisterTimeSlot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorRegisterTimeSlotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorRegisterTimeSlot record);

    DoctorRegisterTimeSlot selectByPrimaryKey(Integer id);

    List<DoctorRegisterTimeSlot> selectAll(DoctorRegisterTimeSlot doctorRegisterTimeSlot);

    int updateByPrimaryKey(DoctorRegisterTimeSlot record);
}