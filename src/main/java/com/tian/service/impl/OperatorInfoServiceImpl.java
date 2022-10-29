package com.tian.service.impl;

import com.tian.entity.OperatorInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.OperatorInfoMapper;
import com.tian.service.OperatorInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * 经办人
 * @date 2022年10月20日 14:33
 */
@Service
public class OperatorInfoServiceImpl implements OperatorInfoService {

    @Resource
    private OperatorInfoMapper operatorInfoMapper;

    @Override
    public List<OperatorInfo> list(OperatorInfo operatorInfo) {
        return operatorInfoMapper.selectAll(operatorInfo);
    }

    @Override
    public String add(OperatorInfo operatorInfo, User user) {
        int count = operatorInfoMapper.count(operatorInfo);
        if (count > 0) {
            return operatorInfo.getOperatorName() + "已存在";
        }
        operatorInfo.setOperationUserId(user.getUserid());
        Date currDate = new Date();
        operatorInfo.setCreateTime(currDate);
        operatorInfo.setUpdateTime(currDate);
        operatorInfo.setStatus(StatusEnum.normal.getCode());
        int flag = operatorInfoMapper.insert(operatorInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String update(OperatorInfo operatorInfo, User user) {
        OperatorInfo operatorInfoOld = operatorInfoMapper.selectByPrimaryKey(operatorInfo.getId());
        operatorInfoOld.setOperatorName(operatorInfo.getOperatorName());
        operatorInfoOld.setOperationUserId(user.getUserid());
        operatorInfoOld.setUpdateTime(new Date());
        int flag = operatorInfoMapper.updateByPrimaryKey(operatorInfoOld);
        if (flag == 1) {
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String delete(OperatorInfo operatorInfo, User user) {
        operatorInfo.setOperationUserId(user.getUserid());
        operatorInfo.setUpdateTime(new Date());
        int flag = operatorInfoMapper.deleteByPrimaryKey(operatorInfo);
        if (flag == 1) {
            return "删除成功";
        }
        return "删除失败";
    }
}
