package com.tian.service.impl;

import com.tian.entity.DrugInfoOperationLog;
import com.tian.mapper.DrugInfoOperationLogMapper;
import com.tian.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月03日 21:46
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Resource
    private DrugInfoOperationLogMapper drugInfoOperationLogMapper;

    @Async("taskExecutor")
    @Override
    public void executeAsyncDrugInfoOperationLog(Date currDate, Integer userId, String beforeContent, String afterContent) {
        DrugInfoOperationLog drugInfoOperationLog = new DrugInfoOperationLog();
        drugInfoOperationLog.setCreateTime(currDate);
        drugInfoOperationLog.setOperationUserId(userId);
        drugInfoOperationLog.setBeforeContent(beforeContent);
        drugInfoOperationLog.setAfterContent(afterContent);
        drugInfoOperationLogMapper.insert(drugInfoOperationLog);
    }
}
