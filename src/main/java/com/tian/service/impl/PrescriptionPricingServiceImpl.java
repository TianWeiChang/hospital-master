package com.tian.service.impl;

import com.tian.entity.PrescriptionPricing;
import com.tian.entity.StorageInOrderInfo;
import com.tian.entity.User;
import com.tian.enums.PaymentStatusEnum;
import com.tian.enums.StatusEnum;
import com.tian.mapper.PrescriptionPricingMapper;
import com.tian.mapper.StorageInOrderInfoMapper;
import com.tian.service.PrescriptionPricingService;
import com.tian.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月23日 20:30
 * 处方划价
 */
@Service
public class PrescriptionPricingServiceImpl implements PrescriptionPricingService {

    @Resource
    private PrescriptionPricingMapper prescriptionPricingMapper;
    @Resource
    private StorageInOrderInfoMapper storageInOrderInfoMapper;

    @Override
    public List<PrescriptionPricing> list(PrescriptionPricing prescriptionPricing) {
        return prescriptionPricingMapper.selectAll(prescriptionPricing);
    }

    @Override
    public Integer queryCountByDrugId(Integer registerId, String drugName) {
        PrescriptionPricing prescriptionPricing = new PrescriptionPricing();
        prescriptionPricing.setPatientRegisterId(registerId);
        prescriptionPricing.setDrugName(drugName);
        return prescriptionPricingMapper.queryCountByDrugId(prescriptionPricing);
    }

    @Override
    public Object querySumByType(Integer registerId, Integer type, Integer paymentStatus) {
        PrescriptionPricing prescriptionPricing = new PrescriptionPricing();
        prescriptionPricing.setPatientRegisterId(registerId);
        prescriptionPricing.setType(type);
        prescriptionPricing.setPaymentStatus(paymentStatus == null ? 0 : paymentStatus);
        return prescriptionPricingMapper.querySumByType(prescriptionPricing);
    }
    @Override
    public Object querySumByRegisterId(Integer registerId) {
        PrescriptionPricing prescriptionPricing = new PrescriptionPricing();
        prescriptionPricing.setPatientRegisterId(registerId);
        return prescriptionPricingMapper.querySumByType(prescriptionPricing);
    }

    @Override
    public Object queryCountInspect(Integer registerId, Integer type, Integer inspectStatus) {
        PrescriptionPricing prescriptionPricing = new PrescriptionPricing();
        prescriptionPricing.setPatientRegisterId(registerId);
        prescriptionPricing.setType(type);
        prescriptionPricing.setInspectStatus(inspectStatus);
        return prescriptionPricingMapper.queryCountInspect(prescriptionPricing);
    }

    @Override
    public Object payByType(Integer registerId, Integer type) {
        PrescriptionPricing prescriptionPricing = new PrescriptionPricing();
        prescriptionPricing.setPatientRegisterId(registerId);
        prescriptionPricing.setType(type);
        return prescriptionPricingMapper.payByType(prescriptionPricing);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(PrescriptionPricing prescriptionPricing, User user) throws Exception {
        prescriptionPricing.setOperationUserId(user.getUserid());
        prescriptionPricing.setCreateTime(DateUtil.getSysDate());
        prescriptionPricing.setUpdateTime(DateUtil.getSysDate());
        prescriptionPricing.setTotal(prescriptionPricing.getDrugCount() * prescriptionPricing.getPrice());
        prescriptionPricing.setPaymentStatus(PaymentStatusEnum.INIT.getCode());
        prescriptionPricing.setStatus(StatusEnum.normal.getCode());
        int flag = prescriptionPricingMapper.insert(prescriptionPricing);
        if (flag != 1) {
            return flag;
        }
        int drugId = prescriptionPricing.getDrugId();
        StorageInOrderInfo storage = new StorageInOrderInfo();
        storage.setDrugId(drugId);
        List<StorageInOrderInfo> storageInOrderInfoList = storageInOrderInfoMapper.selectAll(storage);
        StorageInOrderInfo storageInOrderInfo;
        if (storageInOrderInfoList.size() > 0) {
            storageInOrderInfo = storageInOrderInfoList.get(0);
            //库存扣减
            storageInOrderInfo.setCount(storageInOrderInfo.getCount() - prescriptionPricing.getDrugCount());
            return storageInOrderInfoMapper.updateByPrimaryKey(storageInOrderInfo);
        } else {
            throw new Exception("失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int edit(PrescriptionPricing prescriptionPricing, User user) throws Exception {
        PrescriptionPricing prescriptionPricing1 = prescriptionPricingMapper.selectByRegisterId(prescriptionPricing.getPatientRegisterId(), prescriptionPricing.getDrugName());
        prescriptionPricing1.setDrugCount(prescriptionPricing1.getDrugCount() + prescriptionPricing.getDrugCount());
        prescriptionPricing1.setTotal(prescriptionPricing1.getTotal() + prescriptionPricing.getDrugCount() * prescriptionPricing.getPrice());
        prescriptionPricing1.setOperationUserId(user.getUserid());
        prescriptionPricing1.setUpdateTime(DateUtil.getSysDate());
        int flag = prescriptionPricingMapper.updateByPrimaryKey(prescriptionPricing1);
        if (flag != 1) {
            return flag;
        }
        int drugId = prescriptionPricing.getDrugId();
        StorageInOrderInfo storage = new StorageInOrderInfo();
        storage.setDrugId(drugId);
        List<StorageInOrderInfo> storageInOrderInfoList = storageInOrderInfoMapper.selectAll(storage);
        StorageInOrderInfo storageInOrderInfo;
        if (storageInOrderInfoList.size() > 0) {
            storageInOrderInfo = storageInOrderInfoList.get(0);
            //库存扣减
            storageInOrderInfo.setCount(storageInOrderInfo.getCount() - prescriptionPricing.getDrugCount());
            return storageInOrderInfoMapper.updateByPrimaryKey(storageInOrderInfo);
        } else {
            throw new Exception("失败");
        }
    }

    @Override
    public String delete(PrescriptionPricing prescriptionPricing, User user) {
        PrescriptionPricing prescriptionPricing1 = prescriptionPricingMapper.selectByPrimaryKey(prescriptionPricing.getId());
        if (prescriptionPricing1.getPaymentStatus() == PaymentStatusEnum.INIT.getCode()) {
            return "删除失败，未付款";
        }
        prescriptionPricing.setOperationUserId(user.getUserid());
        prescriptionPricing.setUpdateTime(DateUtil.getSysDate());
        int flag = prescriptionPricingMapper.deleteByPrimaryKey(prescriptionPricing);
        if (flag == 1) {
            return "删除成功";
        }
        return "删除失败";
    }
}
