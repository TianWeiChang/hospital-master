package com.tian.service.impl;

import com.tian.entity.*;
import com.tian.enums.StatusEnum;
import com.tian.mapper.*;
import com.tian.service.DrugInfoService;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 22:53
 * 药品信息
 */
@Service
public class DrugInfoServiceImpl implements DrugInfoService {
    @Resource
    private DrugInfoMapper drugInfoMapper;
    @Resource
    private UnitInfoMapper unitInfoMapper;
    @Resource
    private DrugTypeInfoMapper drugTypeInfoMapper;
    @Resource
    private DrugProductAddressInfoMapper drugProductAddressInfoMapper;
    @Resource
    private StorageInOrderInfoMapper storageInOrderInfoMapper;

    @Override
    public List<DrugInfo> list(DrugInfo drugInfo) {
        if (drugInfo != null && StringUtil.isNullOrEmpty(drugInfo.getDrugName())) {
            drugInfo.setDrugName(null);
        }
        List<DrugInfo> drugInfoList = drugInfoMapper.selectAll(drugInfo);
        if (CollectionUtils.isEmpty(drugInfoList)) {
            return drugInfoList;
        }


        List<UnitInfo> unitInfoList = unitInfoMapper.selectAll(null);
        Map<Integer, String> unitInfoListMap = unitInfoList.stream().collect(Collectors.toMap(UnitInfo::getId, UnitInfo::getUnitName));

        List<DrugTypeInfo> drugTypeInfoList = drugTypeInfoMapper.selectAll(null);
        Map<Integer, String> drugTypeInfoListMap = drugTypeInfoList.stream().collect(Collectors.toMap(DrugTypeInfo::getId, DrugTypeInfo::getDrugTypeName));

        for (DrugInfo drugInfo1 : drugInfoList) {
            drugInfo1.setUnitName(unitInfoListMap.get(drugInfo1.getUnit()));
            drugInfo1.setDrugTypeName(drugTypeInfoListMap.get(drugInfo1.getDrugTypeId()));
            drugInfo1.setPrice(drugInfo1.getPrice());
            StorageInOrderInfo record = new StorageInOrderInfo();
            record.setDrugId(drugInfo1.getId());
            Integer sum = storageInOrderInfoMapper.storageSum(record);
            drugInfo1.setNumber(sum == null ? 0 : sum);
        }
        return drugInfoList;
    }

    @Override
    public String add(DrugInfo drugInfo, User user) {
        int count = drugInfoMapper.count(drugInfo);
        if (count > 0) {
            return drugInfo.getDrugName() + "已存在";
        }
        Date date = new Date();
        drugInfo.setCreateTime(date);
        drugInfo.setUpdateTime(date);
        drugInfo.setPrice(drugInfo.getPrice());
        drugInfo.setStatus(StatusEnum.normal.getCode());
        drugInfo.setOperationUserId(user.getUserid());
        int flag = drugInfoMapper.insert(drugInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String edit(DrugInfo drugInfo, User user) {
        DrugInfo drugInfoOld = drugInfoMapper.selectByPrimaryKey(drugInfo.getId());
        Date date = new Date();
        drugInfoOld.setUpdateTime(date);
        drugInfoOld.setOperationUserId(user.getUserid());
        drugInfoOld.setDrugName(drugInfo.getDrugName());
        drugInfoOld.setPrice(drugInfo.getPrice());
        drugInfoOld.setUnit(drugInfo.getUnit());
        drugInfoOld.setDrugTypeId(drugInfo.getDrugTypeId());
        drugInfoOld.setProductAddress(drugInfo.getProductAddress());
        int flag = drugInfoMapper.updateByPrimaryKey(drugInfoOld);
        if (flag == 1) {
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String delete(Integer id, User user) {
        DrugInfo drugInfoOld = drugInfoMapper.selectByPrimaryKey(id);
        Date date = new Date();
        drugInfoOld.setUpdateTime(date);
        drugInfoOld.setOperationUserId(user.getUserid());
        int flag = drugInfoMapper.deleteByPrimaryKey(drugInfoOld);
        if (flag == 1) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public List<DrugProductAddressInfo> productAddress() {
        return drugProductAddressInfoMapper.selectList(null);
    }

    @Override
    public List<UnitInfo> drugUnit() {
        return unitInfoMapper.selectAll(null);
    }

    @Override
    public List<DrugTypeInfo> drugType() {
        return drugTypeInfoMapper.selectAll(null);
    }
}