package com.tian.service;

import com.tian.entity.RegisterTypeInfo;
import com.tian.entity.RegisteredType;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 挂号类型接口
 * @createTime 2022年10月19日 15:54
 */
public interface RegisteredTypeService {

    List<RegisterTypeInfo> registeredTypeList(RegisterTypeInfo registerTypeInfo);

    String add(RegisterTypeInfo registerTypeInfo, User user);

    String edit(RegisterTypeInfo registerTypeInfo, User user);

    RegisterTypeInfo selectById(Integer id);
}
