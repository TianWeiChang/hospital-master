package com.tian.mapper;

import com.tian.entity.PatientSystemMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PatientSystemMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientSystemMessage record);

    PatientSystemMessage selectByPrimaryKey(Integer id);

    List<PatientSystemMessage> selectAll();

    int updateByPrimaryKey(PatientSystemMessage record);
}