package com.tian.service.impl;

import com.tian.entity.*;
import com.tian.enums.StatusEnum;
import com.tian.mapper.DrugInfoMapper;
import com.tian.mapper.DrugTypeInfoMapper;
import com.tian.mapper.StorageInOrderInfoMapper;
import com.tian.mapper.UnitInfoMapper;
import com.tian.service.StorageInOrderInfoService;
import com.tian.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月22日 16:41
 * <p>
 * 入库单
 */
@Service
public class StorageInOrderInfoServiceImpl implements StorageInOrderInfoService {
    @Resource
    private StorageInOrderInfoMapper storageInOrderInfoMapper;
    @Resource
    private DrugInfoMapper drugInfoMapper;
    @Resource
    private DrugTypeInfoMapper drugTypeInfoMapper;
    @Resource
    private UnitInfoMapper unitInfoMapper;

    @Override
    public List<StorageInOrderInfoRespDto> list(StorageInOrderInfo storageInOrderInfo) {

        List<StorageInOrderInfo> storageInOrderInfoList = storageInOrderInfoMapper.selectAll(storageInOrderInfo);

        List<UnitInfo> unitInfoList = unitInfoMapper.selectAll(null);
        Map<Integer, String> unitInfoListMap = unitInfoList.stream().collect(Collectors.toMap(UnitInfo::getId, UnitInfo::getUnitName));

        List<DrugTypeInfo> drugTypeInfoList = drugTypeInfoMapper.selectAll(null);
        Map<Integer, String> drugTypeInfoListMap = drugTypeInfoList.stream().collect(Collectors.toMap(DrugTypeInfo::getId, DrugTypeInfo::getDrugTypeName));

        List<DrugInfo> drugInfoList = drugInfoMapper.selectList(null);
        Map<Integer, DrugInfo> drugInfoMap = drugInfoList.stream().collect(Collectors.toMap(DrugInfo::getId, Function.identity()));

        List<StorageInOrderInfoRespDto> storageInOrderInfoRespDtos = new ArrayList<>();

        for (StorageInOrderInfo storageInOrder : storageInOrderInfoList) {
            StorageInOrderInfoRespDto storageInOrderInfoRespDto = new StorageInOrderInfoRespDto();

            storageInOrderInfoRespDto.setId(storageInOrder.getId());
            storageInOrderInfoRespDto.setCount(storageInOrder.getCount());
            storageInOrderInfoRespDto.setWholeSalePrice(storageInOrder.getWholeSalePrice());
            storageInOrderInfoRespDto.setWarehouseName(storageInOrder.getWarehouseName());
            storageInOrderInfoRespDto.setSupplierName(storageInOrder.getSupplierName());
            storageInOrderInfoRespDto.setPrice(storageInOrder.getPrice());
            storageInOrderInfoRespDto.setOperatorName(storageInOrder.getOperatorName());
            storageInOrderInfoRespDto.setDrugName(storageInOrder.getDrugName());

            DrugInfo drugInfo = drugInfoMap.get(storageInOrder.getDrugId());


            /*storageInOrderInfoRespDto.setProductAddress(drugInfo.getProductAddress());
            storageInOrderInfoRespDto.setUnitName(unitInfoListMap.get(drugInfo.getUnit()));*/
            storageInOrderInfoRespDto.setDrugTypeName(drugTypeInfoListMap.get(drugInfo.getDrugTypeId()));

            storageInOrderInfoRespDto.setProductDateStr(DateUtil.format(storageInOrder.getProductDate(), DateUtil.DATEFORMATDAY));
            storageInOrderInfoRespDto.setValidDateStr(DateUtil.format(storageInOrder.getValidDate(), DateUtil.DATEFORMATDAY));

            // TODO: 2022/10/23 表新增字段
            storageInOrderInfoRespDto.setBatch("20221023");
            storageInOrderInfoRespDtos.add(storageInOrderInfoRespDto);
        }

        return storageInOrderInfoRespDtos;
    }

    @Override
    public Integer add(StorageInOrderInfoDto storageInOrderInfoDto, User user) {
        StorageInOrderInfo storageInOrderInfo = new StorageInOrderInfo();
        storageInOrderInfo.setCount(storageInOrderInfoDto.getStorageCount());
        try {
            storageInOrderInfo.setValidDate(DateUtil.string2Date(storageInOrderInfoDto.getValidDateStr()));
            storageInOrderInfo.setProductDate(DateUtil.string2Date(storageInOrderInfoDto.getProductDateStr()));
        } catch (ParseException e) {
            // TODO: 2022/10/23 待替换成log输出
            e.printStackTrace();
        }
        DrugInfo drugInfo = drugInfoMapper.selectByPrimaryKey(storageInOrderInfoDto.getDrugInfoId());
        storageInOrderInfo.setDrugId(storageInOrderInfoDto.getDrugInfoId());
        storageInOrderInfo.setDrugName(drugInfo.getDrugName());
        storageInOrderInfo.setDrugTypeId(drugInfo.getDrugTypeId());
        storageInOrderInfo.setOperationUserId(user.getUserid());
        storageInOrderInfo.setOperatorName(storageInOrderInfoDto.getOperatorName());
        storageInOrderInfo.setPrice(storageInOrderInfoDto.getSellingPrice());

        storageInOrderInfo.setStatus(StatusEnum.normal.getCode());
        storageInOrderInfo.setSupplierName(storageInOrderInfoDto.getSupplierName());
        storageInOrderInfo.setWarehouseName(storageInOrderInfoDto.getWarehouseName());
        storageInOrderInfo.setWholeSalePrice(storageInOrderInfoDto.getTradePrice());
        /*storageInOrderInfo.setUnit(drugInfo.getUnit());*/

        Date date = DateUtil.getSysDate();
        storageInOrderInfo.setCreateTime(date);
        storageInOrderInfo.setUpdateTime(date);
        return storageInOrderInfoMapper.insert(storageInOrderInfo);
    }

    @Override
    public int storageSum(StorageInOrderInfo record) {
        return storageInOrderInfoMapper.storageSum(record);
    }
}
