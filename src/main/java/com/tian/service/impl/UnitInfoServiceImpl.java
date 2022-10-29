package com.tian.service.impl;

import com.tian.entity.UnitInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.UnitInfoMapper;
import com.tian.service.UnitInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 22:24
 */
@Service
public class UnitInfoServiceImpl implements UnitInfoService {
    @Resource
    private UnitInfoMapper unitInfoMapper;

    @Override
    public List<UnitInfo> list(UnitInfo unitInfo) {
        return unitInfoMapper.selectAll(unitInfo);
    }

    @Override
    public String add(UnitInfo unitInfo, User user) {
        int count = unitInfoMapper.count(unitInfo);
        if (count > 0) {
            return unitInfo.getUnitName() + "已存在";
        }
        Date date =new Date();
        unitInfo.setCreateTime(date);
        unitInfo.setUpdateTime(date);
        unitInfo.setStatus(StatusEnum.normal.getCode());
        unitInfo.setOperationUserId(user.getUserid());
        int flag = unitInfoMapper.insert(unitInfo);
        if(flag==1){
            return "添加成功";
        }
        return "添加失败";
    }
}
