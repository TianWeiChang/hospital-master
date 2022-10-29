package com.tian.service.impl;

import com.tian.entity.DepartmentInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.DepartmentInfoMapper;
import com.tian.service.DepartmentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 科室信息处理实现类
 * @createTime 2022年10月19日 19:08
 */
@Service
public class DepartmentInfoServiceImpl implements DepartmentInfoService {
    @Resource
    private DepartmentInfoMapper departmentInfoMapper;

    @Override
    public List<DepartmentInfo> departmentList(DepartmentInfo departments) {
        return departmentInfoMapper.selectAll(departments);
    }

    @Override
    public String add(DepartmentInfo departmentInfo, User user) {
        int count = departmentInfoMapper.count(departmentInfo);
        if (count > 0) {
            return departmentInfo.getDepartmentName() + " 已存在";
        }
        departmentInfo.setOperationUserId(user.getUserid());
        Date currDate = new Date();
        departmentInfo.setCreateTime(currDate);
        departmentInfo.setUpdateTime(currDate);
        departmentInfo.setStatus(StatusEnum.normal.getCode());
        int flag = departmentInfoMapper.insert(departmentInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String edit(DepartmentInfo departmentInfo, User user) {
        departmentInfo.setOperationUserId(user.getUserid());
        departmentInfo.setUpdateTime(new Date());
        departmentInfo.setStatus(StatusEnum.normal.getCode());
        int flag = departmentInfoMapper.updateByPrimaryKey(departmentInfo);
        if (flag == 1) {
            return "修改成功";
        }
        return "修改失败";
    }
}
