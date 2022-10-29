package com.tian.mapper;

import com.tian.entity.DrugProductAddressInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * 药品产地
 */
@Mapper
public interface DrugProductAddressInfoMapper {
    /**
     * 通过主键删除药品产地（逻辑删除改状态）
     *
     * @param record 药品产地信息
     * @return 结果
     */
    int deleteByPrimaryKey(DrugProductAddressInfo record);

    /**
     * 新增药品产地信息
     *
     * @param record 药品产地信息
     * @return 结果
     */
    int insert(DrugProductAddressInfo record);

    /**
     * 通过主键id查询药品产地信息
     *
     * @param id 主键id
     * @return 结果
     */
    DrugProductAddressInfo selectByPrimaryKey(Integer id);

    /**
     * 药品产地信息列表
     *
     * @param record 药品产地信息查询条件
     * @return 供货商信息列表
     */
    List<DrugProductAddressInfo> selectList(DrugProductAddressInfo record);

    /**
     * 修改药品产地信息
     *
     * @param record 药品产地信息
     * @return 结果
     */
    int updateByPrimaryKey(DrugProductAddressInfo record);

    /**
     * 统计药品产地数量
     *
     * @param record 供药品产地信息
     * @return 结果
     */
    int count(DrugProductAddressInfo record);
}