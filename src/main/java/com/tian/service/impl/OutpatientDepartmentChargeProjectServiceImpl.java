package com.tian.service.impl;

import com.tian.entity.OutpatientDepartmentChargeProject;
import com.tian.entity.ProjectBigType;
import com.tian.entity.UnitInfo;
import com.tian.entity.User;
import com.tian.enums.PaymentStatusEnum;
import com.tian.enums.StatusEnum;
import com.tian.mapper.OutpatientDepartmentChargeProjectMapper;
import com.tian.mapper.ProjectBigTypeMapper;
import com.tian.mapper.UnitInfoMapper;
import com.tian.service.OutpatientDepartmentChargeProjectService;
import com.tian.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月25日 17:26
 */
@Service
public class OutpatientDepartmentChargeProjectServiceImpl implements OutpatientDepartmentChargeProjectService {

    @Resource
    private UnitInfoMapper unitInfoMapper;
    @Resource
    private ProjectBigTypeMapper projectBigTypeMapper;
    @Resource
    private OutpatientDepartmentChargeProjectMapper outpatientDepartmentChargeProjectMapper;

    @Override
    public List<OutpatientDepartmentChargeProject> list(OutpatientDepartmentChargeProject outpatientDepartmentChargeProject) {
        return outpatientDepartmentChargeProjectMapper.selectAll(outpatientDepartmentChargeProject);
    }

    @Override
    public String add(OutpatientDepartmentChargeProject outpatientDepartmentChargeProject, User user) {

        ProjectBigType projectBigType = projectBigTypeMapper.selectByPrimaryKey(outpatientDepartmentChargeProject.getProjectBigTypeId());

        UnitInfo unitInfo = unitInfoMapper.selectByPrimaryKey(outpatientDepartmentChargeProject.getUnitId());

        int count = outpatientDepartmentChargeProjectMapper.count(outpatientDepartmentChargeProject);
        if (count > 0) {
            return outpatientDepartmentChargeProject.getOutpatientDepartmentProjectName() + "已存在";
        }

        outpatientDepartmentChargeProject.setUnitName(unitInfo.getUnitName());
        outpatientDepartmentChargeProject.setProjectBigTypeName(projectBigType.getProjectBigTypeName());

        outpatientDepartmentChargeProject.setOperationUserId(user.getUserid());
        outpatientDepartmentChargeProject.setCreateTime(DateUtil.getSysDate());
        outpatientDepartmentChargeProject.setUpdateTime(DateUtil.getSysDate());
        outpatientDepartmentChargeProject.setStatus(StatusEnum.normal.getCode());

        int flag = outpatientDepartmentChargeProjectMapper.insert(outpatientDepartmentChargeProject);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
