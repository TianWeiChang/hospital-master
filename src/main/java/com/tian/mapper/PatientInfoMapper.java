package com.tian.mapper;

import com.tian.entity.PatientInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientInfo record);

    PatientInfo selectByPrimaryKey(Integer id);

    List<PatientInfo> selectAll(PatientInfo patientInfo);

    List<PatientInfo> selectByIdList(List<Integer> ids);

    PatientInfo selectByCardId(PatientInfo patientInfo);

    int updateByPrimaryKey(PatientInfo record);

    int count(PatientInfo record);
}