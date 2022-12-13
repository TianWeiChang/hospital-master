package com.tian.mapper;

import com.tian.entity.SmsCoupon;
import java.util.List;

public interface SmsCouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCoupon record);

    SmsCoupon selectByPrimaryKey(Long id);

    List<SmsCoupon> selectAll();

    int updateByPrimaryKey(SmsCoupon record);
}