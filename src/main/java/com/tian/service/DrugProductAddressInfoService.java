package com.tian.service;

import com.tian.entity.DrugProductAddressInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 16:14
 * 药品产地信息
 */
public interface DrugProductAddressInfoService {
    /**
     * 查询药品产地信息列表
     *
     * @param drugProductAddressInfo 查询条件
     * @return 药品产地信息列表
     */
    List<DrugProductAddressInfo> list(DrugProductAddressInfo drugProductAddressInfo);

    /**
     * 添加药品产地信息
     *
     * @param drugProductAddressInfo 药品产地信息
     * @return 结果提示
     */
    String add(DrugProductAddressInfo drugProductAddressInfo, User user);
}
