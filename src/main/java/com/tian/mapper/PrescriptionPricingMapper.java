package com.tian.mapper;

import com.tian.entity.PrescriptionPricing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrescriptionPricingMapper {
    int deleteByPrimaryKey(PrescriptionPricing prescriptionPricing);

    int insert(PrescriptionPricing record);

    PrescriptionPricing selectByPrimaryKey(Integer id);

    int queryCountByDrugId(PrescriptionPricing prescriptionPricing);

    int queryCountInspect(PrescriptionPricing prescriptionPricing);

    Integer querySumByType(PrescriptionPricing prescriptionPricing);

    Integer payByType(PrescriptionPricing prescriptionPricing);

    List<PrescriptionPricing> selectAll(PrescriptionPricing prescriptionPricing);

    PrescriptionPricing selectByRegisterId(@Param("patientRegisterId") Integer patientRegisterId, @Param("drugName") String drugName);

    int updateByPrimaryKey(PrescriptionPricing record);
}