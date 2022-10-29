package com.tian.mapper;

import com.tian.entity.SupplierInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * 供货商持久层
 */
@Mapper
public interface SupplierInfoMapper {
    /**
     * 通过主键删除供货商信息 （逻辑删除改状态）
     *
     * @param supplierInfo 供货商信息
     * @return 结果
     */
    int deleteByPrimaryKey(SupplierInfo supplierInfo);

    /**
     * 新增供货商信息
     *
     * @param record 供货商信息
     * @return 结果
     */
    int insert(SupplierInfo record);

    /**
     * 通过主键id查询供货商信息
     *
     * @param id 主键id
     * @return 结果
     */
    SupplierInfo selectByPrimaryKey(Integer id);

    /**
     * 供货商信息
     *
     * @param record 供货商信息查询条件
     * @return 供货商信息列表
     */
    List<SupplierInfo> selectList(SupplierInfo record);

    /**
     * 修改供货商信息
     *
     * @param record 供货商信息
     * @return 结果
     */
    int updateByPrimaryKey(SupplierInfo record);

    /**
     * 统计供货商数量
     *
     * @param record 供货商信息
     * @return 结果
     */
    int count(SupplierInfo record);
}