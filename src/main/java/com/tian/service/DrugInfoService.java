package com.tian.service;

import com.tian.entity.*;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 22:52
 * <p>
 * 药品字典信息操作
 */
public interface DrugInfoService {

    /**
     * 药品信息列表
     */
    List<DrugInfo> list(DrugInfo drugInfo);

    /**
     * 添加药品信息
     */
    String add(DrugInfo drugInfo, User user);

    /**
     * 修改药品信息
     */
    String edit(DrugInfo drugInfo, User user);

    /**
     * 删除药品信息
     */
    String delete(Integer id, User user);

    List<DrugProductAddressInfo> productAddress();

    List<UnitInfo> drugUnit();

    List<DrugTypeInfo> drugType();
}
