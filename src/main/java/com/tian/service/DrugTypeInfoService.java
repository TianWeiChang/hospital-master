package com.tian.service;

import com.tian.entity.DrugTypeInfo;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 16:29
 * 药品分类信息
 */
public interface DrugTypeInfoService {

    /**
     * 查询药品分类信息列表
     *
     * @param drugTypeInfo 查询条件
     * @return 药品分类信息列表
     */
    List<DrugTypeInfo> list(DrugTypeInfo drugTypeInfo);

    /**
     * 添加药品分类信息
     *
     * @param drugTypeInfo 药品分类信息
     * @param user         操作人员信息
     * @return 结果提示
     */
    String add(DrugTypeInfo drugTypeInfo, User user);
}
