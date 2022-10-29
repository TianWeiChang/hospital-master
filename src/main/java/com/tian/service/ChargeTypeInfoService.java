package com.tian.service;

import com.tian.entity.ChargeTypeInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月26日 14:39
 */
public interface ChargeTypeInfoService {

    List<ChargeTypeInfo> list(ChargeTypeInfo chargeTypeInfo);

    String add(ChargeTypeInfo chargeTypeInfo, User user);
}
