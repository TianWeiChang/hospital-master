package com.tian.service.impl;

import com.tian.entity.RegisterTypeInfo;
import com.tian.entity.RegisteredType;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.RegisterTypeInfoMapper;
import com.tian.service.RegisteredTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 挂号类型处理实现类
 * @createTime 2022年10月19日 15:54
 */
@Service
public class RegisteredTypeServiceImpl implements RegisteredTypeService {

    @Resource
    private RegisterTypeInfoMapper registerTypeInfoMapper;

    @Override
    public List<RegisterTypeInfo> registeredTypeList(RegisterTypeInfo registerTypeInfo) {
        return registerTypeInfoMapper.selectAll(registerTypeInfo);
    }

    @Override
    public String edit(RegisterTypeInfo registerTypeInfo, User user) {
        registerTypeInfo.setUpdateTime(new Date());
        registerTypeInfo.setOperationUserId(user.getUserid());
        int flag = registerTypeInfoMapper.updateByPrimaryKey(registerTypeInfo);
        if (flag == 1) {
            return "更新成功!";
        }
        return "更新失败!";
    }

    @Override
    public RegisterTypeInfo selectById(Integer id) {
        return registerTypeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String add(RegisterTypeInfo registerTypeInfo, User user) {
        int count = registerTypeInfoMapper.count(registerTypeInfo);
        if (count > 0) {
            return registerTypeInfo.getRegisterTypeName() + " 已存在";
        }
        Date currDate = new Date();
        registerTypeInfo.setCreateTime(currDate);
        registerTypeInfo.setUpdateTime(currDate);
        registerTypeInfo.setOperationUserId(user.getUserid());
        registerTypeInfo.setStatus(StatusEnum.normal.getCode());
        int flag = registerTypeInfoMapper.insert(registerTypeInfo);
        if (flag == 1) {
            return "新增成功!";
        }
        return "新增失败!";
    }
}
