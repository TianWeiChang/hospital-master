package com.tian.service;

import com.tian.entity.DepartmentInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 科室信息处理接口
 * @createTime 2022年10月19日 19:08
 */
public interface DepartmentInfoService {

    List<DepartmentInfo> departmentList(DepartmentInfo departments);

    String add(DepartmentInfo departmentInfo, User user);

    String edit(DepartmentInfo departmentInfo, User user);
}
