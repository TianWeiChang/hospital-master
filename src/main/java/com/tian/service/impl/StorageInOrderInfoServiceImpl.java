package com.tian.service.impl;

import com.tian.entity.*;
import com.tian.enums.StatusEnum;
import com.tian.mapper.DrugInfoMapper;
import com.tian.mapper.DrugTypeInfoMapper;
import com.tian.mapper.StorageInOrderInfoMapper;
import com.tian.mapper.UnitInfoMapper;
import com.tian.service.StorageInOrderInfoService;
import com.tian.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
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
@Slf4j
@Service
public class StorageInOrderInfoServiceImpl implements StorageInOrderInfoService {
    @Resource
    private StorageInOrderInfoMapper storageInOrderInfoMapper;

    @Override
    public List<StorageInOrderInfoRespDto> list(String drugName) {
        return storageInOrderInfoMapper.selectListPage(drugName);
    }

    @Transactional(isolation= Isolation.DEFAULT)
    @Override
    public Integer add(StorageInOrderInfoDto storageInOrderInfoDto, User user) {
        StorageInOrderInfo storageInOrderInfo = new StorageInOrderInfo();
        storageInOrderInfo.setCount(storageInOrderInfoDto.getStorageCount());
        try {
            storageInOrderInfo.setValidDate(DateUtil.string2Date(storageInOrderInfoDto.getValidDateStr()));
            storageInOrderInfo.setProductDate(DateUtil.string2Date(storageInOrderInfoDto.getProductDateStr()));
        } catch (ParseException e) {
            log.error("日期转换失败", e);
            return 0;
        }
        storageInOrderInfo.setDrugInfoId(storageInOrderInfoDto.getDrugInfoId());
        storageInOrderInfo.setOperatorInfoId(storageInOrderInfoDto.getOperatorId());
        storageInOrderInfo.setStatus(StatusEnum.normal.getCode());
        storageInOrderInfo.setSupplierInfoId(storageInOrderInfoDto.getSupplierId());
        storageInOrderInfo.setWarehouseInfoId(storageInOrderInfoDto.getWarehouseId());
        storageInOrderInfo.setWholeSalePrice(storageInOrderInfoDto.getTradePrice());
        storageInOrderInfo.setBatchNo(storageInOrderInfoDto.getBatch());

        int flag = storageInOrderInfoMapper.insert(storageInOrderInfo);
        if (flag == 1) {
            // TODO: 2022/11/6 发送 消息 到 MQ中 操作日志记录
        }
        return flag;
    }

    @Override
    public int storageSum(Integer drugInfoId) {
        return storageInOrderInfoMapper.storageSum(drugInfoId);
    }
}
