package com.tian.mapper;

import com.tian.entity.DrugTypeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * 药品类型
 */
@Mapper
public interface DrugTypeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DrugTypeInfo record);

    DrugTypeInfo selectByPrimaryKey(Integer id);

    List<DrugTypeInfo> selectAll(DrugTypeInfo drugTypeInfo);

    int updateByPrimaryKey(DrugTypeInfo record);

    int count(DrugTypeInfo record);
}