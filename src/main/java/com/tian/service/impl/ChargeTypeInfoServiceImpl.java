package com.tian.service.impl;

import com.tian.entity.ChargeTypeInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.ChargeTypeInfoMapper;
import com.tian.service.ChargeTypeInfoService;
import com.tian.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月26日 14:40
 */
@Service
public class ChargeTypeInfoServiceImpl implements ChargeTypeInfoService {

    @Resource
    private ChargeTypeInfoMapper chargeTypeInfoMapper;

    @Override
    public List<ChargeTypeInfo> list(ChargeTypeInfo chargeTypeInfo) {
        return chargeTypeInfoMapper.selectAll(chargeTypeInfo);
    }

    @Override
    public String add(ChargeTypeInfo chargeTypeInfo, User user) {
        Integer count = chargeTypeInfoMapper.count(chargeTypeInfo);
        if (count != null && count > 0) {
            return chargeTypeInfo.getTypeName() + "已存在";
        }

        chargeTypeInfo.setOperationUserId(user.getUserid());
        chargeTypeInfo.setCreateTime(DateUtil.getSysDate());
        chargeTypeInfo.setUpdateTime(DateUtil.getSysDate());
        chargeTypeInfo.setStatus(StatusEnum.normal.getCode());

        int flag = chargeTypeInfoMapper.insert(chargeTypeInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
