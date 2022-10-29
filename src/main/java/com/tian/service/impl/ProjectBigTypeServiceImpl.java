package com.tian.service.impl;

import com.tian.entity.ProjectBigType;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.ProjectBigTypeMapper;
import com.tian.service.ProjectBigTypeService;
import com.tian.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月25日 15:44
 */
@Service
public class ProjectBigTypeServiceImpl implements ProjectBigTypeService {

    @Resource
    private ProjectBigTypeMapper projectBigTypeMapper;

    @Override
    public List<ProjectBigType> list(ProjectBigType projectBigType) {
        return projectBigTypeMapper.selectAll(projectBigType);
    }

    @Override
    public String add(ProjectBigType projectBigType, User user) {
        projectBigType.setOperationUserId(user.getUserid());
        projectBigType.setCreateTime(DateUtil.getSysDate());
        projectBigType.setUpdateTime(DateUtil.getSysDate());
        projectBigType.setStatus(StatusEnum.normal.getCode());
        Integer count = projectBigTypeMapper.count(projectBigType);
        if (count != null && count > 0) {
            return projectBigType.getProjectBigTypeName() + "已存在";
        }
        int flag = projectBigTypeMapper.insert(projectBigType);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
