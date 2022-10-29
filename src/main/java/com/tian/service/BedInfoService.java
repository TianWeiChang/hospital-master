package com.tian.service;

import com.tian.entity.BedInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月26日 14:11
 */
public interface BedInfoService {
    List<BedInfo> list(BedInfo bedInfo);

    String add(BedInfo bedInfo, User user);
}
