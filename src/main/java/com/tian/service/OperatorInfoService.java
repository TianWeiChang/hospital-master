package com.tian.service;

import com.tian.entity.OperatorInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * 经办人
 */
public interface OperatorInfoService {
    /**
     * 经办人列表
     *
     * @param operatorInfo 搜索栏中的条件
     * @return 经办人列表
     */
    List<OperatorInfo> list(OperatorInfo operatorInfo);

    /**
     * 添加经办人
     *
     * @param operatorInfo 新增经办人信息
     * @param user 操作人员信息
     * @return 提示信息
     */
    String add(OperatorInfo operatorInfo, User user);

    /**
     * 修改经办人
     *
     * @param operatorInfo 修改经办人信息参数
     * @param user 操作人员信息
     * @return 提示信息
     */
    String update(OperatorInfo operatorInfo, User user);

    /**
     * 删除经办人
     *
     * @param operatorInfo 修改经办人信息参数
     * @param user 操作人员信息
     * @return 提示信息
     */
    String delete(OperatorInfo operatorInfo, User user);
}
