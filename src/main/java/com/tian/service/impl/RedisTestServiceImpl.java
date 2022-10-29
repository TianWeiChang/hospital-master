package com.tian.service.impl;

import com.tian.config.RedisConfig;
import com.tian.service.RedisTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description TODO
 * @createTime 2022年10月12日 09:32
 */
@Slf4j
@Service
public class RedisTestServiceImpl implements RedisTestService {

    @Resource
    private RedisConfig redisConfig;

    @Override
    public void redisTest() {
        String key = "user-name";
        log.info("开始操作缓存");
        redisConfig.add(key,"田哥");
        log.info("获取缓存:{}",redisConfig.get(key));

    }
}
