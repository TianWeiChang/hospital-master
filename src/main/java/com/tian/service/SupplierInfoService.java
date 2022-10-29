package com.tian.service;

import com.tian.entity.SupplierInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 供货商
 * @createTime 2022年10月20日 15:57
 */
public interface SupplierInfoService {
    /**
     * 供货商信息
     *
     * @param supplierInfo 供货商信息查询条件
     * @return 供货商信息列表
     */
    List<SupplierInfo> list(SupplierInfo supplierInfo);

    /**
     * 新增供货商信息
     *
     * @param supplierInfo 供货商信息
     * @param user 操作人员信息
     * @return 结果
     */
    String add(SupplierInfo supplierInfo, User user);

    /**
     * 删除供货商信息
     *
     * @param supplierInfo 供货商信息
     * @param user 操作人员信息
     * @return 结果
     */
    String delete(SupplierInfo supplierInfo, User user);
}
