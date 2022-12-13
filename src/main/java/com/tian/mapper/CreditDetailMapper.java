package com.tian.mapper;

import com.tian.entity.CreditDetail;
import java.util.List;

public interface CreditDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditDetail record);

    CreditDetail selectByPrimaryKey(Integer id);

    List<CreditDetail> selectAll();

    int updateByPrimaryKey(CreditDetail record);
}