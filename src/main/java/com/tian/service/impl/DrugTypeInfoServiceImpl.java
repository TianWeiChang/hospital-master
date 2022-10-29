package com.tian.service.impl;

import com.tian.entity.DrugTypeInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.DrugTypeInfoMapper;
import com.tian.service.DrugTypeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 16:31
 * 药品分类信息
 */
@Service
public class DrugTypeInfoServiceImpl implements DrugTypeInfoService {

    @Resource
    private DrugTypeInfoMapper drugTypeInfoMapper;

    @Override
    public List<DrugTypeInfo> list(DrugTypeInfo drugTypeInfo) {
        return drugTypeInfoMapper.selectAll(drugTypeInfo);
    }

    @Override
    public String add(DrugTypeInfo drugTypeInfo, User user) {
        int count = drugTypeInfoMapper.count(drugTypeInfo);
        if (count > 0) {
            return drugTypeInfo.getDrugTypeName() + "已存在";
        }
        Date date =new Date();
        drugTypeInfo.setCreateTime(date);
        drugTypeInfo.setUpdateTime(date);
        drugTypeInfo.setStatus(StatusEnum.normal.getCode());
        drugTypeInfo.setOperationUserId(user.getUserid());
        int flag = drugTypeInfoMapper.insert(drugTypeInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
