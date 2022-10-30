package com.tian.service;

import com.tian.entity.HospitalizationInfo;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月30日 17:02
 */
public interface HospitalizationInfoService {

    List<HospitalizationInfo> list(HospitalizationInfo hospitalizationInfo);

    String add(HospitalizationInfo hospitalizationInfo);
}
