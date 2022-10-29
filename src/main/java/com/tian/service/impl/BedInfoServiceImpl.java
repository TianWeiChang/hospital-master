package com.tian.service.impl;

import com.tian.entity.BedInfo;
import com.tian.entity.DepartmentInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.BedInfoMapper;
import com.tian.mapper.DepartmentInfoMapper;
import com.tian.service.BedInfoService;
import com.tian.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月26日 14:12
 */
@Service
public class BedInfoServiceImpl implements BedInfoService {
    @Resource
    private BedInfoMapper bedInfoMapper;

    @Resource
    private DepartmentInfoMapper departmentInfoMapper;

    @Override
    public List<BedInfo> list(BedInfo bedInfo) {
        return bedInfoMapper.selectAll(bedInfo);
    }

    @Override
    public String add(BedInfo bedInfo, User user) {
        Integer count = bedInfoMapper.count(bedInfo);
        if (count != null && count > 0) {
            return bedInfo.getBedName() + "已存在";
        }
        DepartmentInfo departmentInfo = departmentInfoMapper.selectByPrimaryKey(bedInfo.getDepartmentId());
        bedInfo.setDepartmentName(departmentInfo.getDepartmentName());
        bedInfo.setOperationUserId(user.getUserid());
        bedInfo.setCreateTime(DateUtil.getSysDate());
        bedInfo.setUpdateTime(DateUtil.getSysDate());
        bedInfo.setStatus(StatusEnum.normal.getCode());
        int flag = bedInfoMapper.insert(bedInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
