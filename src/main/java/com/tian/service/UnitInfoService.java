package com.tian.service;

import com.tian.entity.UnitInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 22:24
 */
public interface UnitInfoService {

    List<UnitInfo> list(UnitInfo unitInfo);

    String add(UnitInfo unitInfo, User user);
}
