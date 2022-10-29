package com.tian.service;

import com.tian.entity.*;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 22:52
 */
public interface DrugInfoService {

    List<DrugInfo> list(DrugInfo drugInfo);

    String add(DrugInfo drugInfo, User user);

    String edit(DrugInfo drugInfo, User user);

    String delete(Integer id, User user);

    List<DrugProductAddressInfo> productAddress();

    List<UnitInfo> drugUnit();

    List<DrugTypeInfo> drugType();
}
