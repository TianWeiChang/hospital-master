package com.tian.service;

import java.util.Date;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月03日 21:44
 * <p>
 * 异步日志记录
 */
public interface AsyncService {
    /**
     * 药品字典操作日志记录 异步执行
     *
     * @param currDate      当前时间
     * @param userId        操作人id
     * @param beforeContent 操作前内容
     * @param afterContent  操作后内存
     */
    void executeAsyncDrugInfoOperationLog(Date currDate, Integer userId, String beforeContent, String afterContent);
}
