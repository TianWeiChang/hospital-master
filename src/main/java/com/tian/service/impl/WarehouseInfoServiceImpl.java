package com.tian.service.impl;

import com.tian.entity.User;
import com.tian.entity.WarehouseInfo;
import com.tian.enums.StatusEnum;
import com.tian.mapper.WarehouseInfoMapper;
import com.tian.service.WarehouseInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description TODO
 * @createTime 2022年10月19日 22:20
 */
@Service
public class WarehouseInfoServiceImpl implements WarehouseInfoService {
    @Resource
    private WarehouseInfoMapper warehouseInfoMapper;

    @Override
    public List<WarehouseInfo> list(WarehouseInfo warehouseInfo) {
        if (warehouseInfo != null && StringUtils.isEmpty(warehouseInfo.getWarehouseName())) {
            warehouseInfo.setWarehouseName(null);
        }
        return warehouseInfoMapper.selectAll(warehouseInfo);
    }

    @Override
    public String add(WarehouseInfo warehouseInfo, User user) {
        int count = warehouseInfoMapper.count(warehouseInfo);
        if (count > 0) {
            return warehouseInfo.getWarehouseName() + "已存在";
        }
        Date currDate = new Date();
        warehouseInfo.setCreateTime(currDate);
        warehouseInfo.setUpdateTime(currDate);
        warehouseInfo.setOperationUserId(user.getUserid());
        warehouseInfo.setStatus(StatusEnum.normal.getCode());
        int flag = warehouseInfoMapper.insert(warehouseInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
