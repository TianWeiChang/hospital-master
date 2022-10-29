package com.tian.service;

import com.tian.entity.PrescriptionPricing;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月23日 20:29
 */
public interface PrescriptionPricingService {

    List<PrescriptionPricing> list(PrescriptionPricing prescriptionPricing);

    Integer queryCountByDrugId(Integer registerId, String drugName);

    Object querySumByType(Integer registerId, Integer type,Integer paymentStatus);

    Object querySumByRegisterId(Integer registerId);

    Object queryCountInspect(Integer registerId, Integer type,Integer inspectStatus);

    Object payByType(Integer registerId, Integer type);

    int add(PrescriptionPricing prescriptionPricing, User user) throws Exception;

    int edit(PrescriptionPricing prescriptionPricing, User user) throws Exception;

    String delete(PrescriptionPricing prescriptionPricing, User user);
}
