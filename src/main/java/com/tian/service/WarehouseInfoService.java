package com.tian.service;

import com.tian.entity.User;
import com.tian.entity.WarehouseInfo;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 仓库操作接口
 * @createTime 2022年10月19日 22:19
 */
public interface WarehouseInfoService {

    List<WarehouseInfo> list(WarehouseInfo warehouseInfo);

    String add(WarehouseInfo warehouseInfo, User user);
}
