package com.tian.service;

import com.tian.entity.StorageInOrderInfo;
import com.tian.entity.StorageInOrderInfoDto;
import com.tian.entity.StorageInOrderInfoRespDto;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月22日 16:40
 */
public interface StorageInOrderInfoService {
    List<StorageInOrderInfoRespDto> list(StorageInOrderInfo storageInOrderInfo);

    Integer add(StorageInOrderInfoDto storageInOrderInfoDto, User user);

    int storageSum(StorageInOrderInfo record);
}
