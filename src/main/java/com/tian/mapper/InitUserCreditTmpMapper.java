package com.tian.mapper;

import com.tian.entity.InitUserCreditTmp;
import java.util.List;

public interface InitUserCreditTmpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InitUserCreditTmp record);

    InitUserCreditTmp selectByPrimaryKey(Long id);

    List<InitUserCreditTmp> selectAll();

    int updateByPrimaryKey(InitUserCreditTmp record);
}