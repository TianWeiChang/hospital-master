package com.tian.service.impl;

import com.tian.entity.DrugProductAddressInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.DrugProductAddressInfoMapper;
import com.tian.service.DrugProductAddressInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 16:16
 */
@Service
public class DrugProductAddressInfoServiceImpl implements DrugProductAddressInfoService {

    @Resource
    private DrugProductAddressInfoMapper drugProductAddressInfoMapper;

    @Override
    public List<DrugProductAddressInfo> list(DrugProductAddressInfo drugProductAddressInfo) {
        return drugProductAddressInfoMapper.selectList(drugProductAddressInfo);
    }

    @Override
    public String add(DrugProductAddressInfo drugProductAddressInfo, User user) {
        int count = drugProductAddressInfoMapper.count(drugProductAddressInfo);
        if (count > 0) {
            return drugProductAddressInfo.getDrugProductAddressName() + "已存在";
        }
        Date date = new Date();
        drugProductAddressInfo.setCreateTime(date);
        drugProductAddressInfo.setUpdateTime(date);
        drugProductAddressInfo.setStatus(StatusEnum.normal.getCode());
        drugProductAddressInfo.setOperationUserId(user.getUserid());
        int flag = drugProductAddressInfoMapper.insert(drugProductAddressInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
