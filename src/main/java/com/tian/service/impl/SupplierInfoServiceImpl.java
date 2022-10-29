package com.tian.service.impl;

import com.tian.entity.SupplierInfo;
import com.tian.entity.User;
import com.tian.enums.StatusEnum;
import com.tian.mapper.SupplierInfoMapper;
import com.tian.service.SupplierInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 15:59
 * 供货商信息处理实现类
 */
@Service
public class SupplierInfoServiceImpl implements SupplierInfoService {
    @Resource
    private SupplierInfoMapper supplierInfoMapper;

    @Override
    public List<SupplierInfo> list(SupplierInfo supplierInfo) {
        return supplierInfoMapper.selectList(supplierInfo);
    }

    @Override
    public String add(SupplierInfo supplierInfo, User user) {
        int count = supplierInfoMapper.count(supplierInfo);
        if (count > 0) {
            return supplierInfo.getSupplierName() + "已存在";
        }
        Date date = new Date();
        supplierInfo.setCreateTime(date);
        supplierInfo.setUpdateTime(date);
        supplierInfo.setStatus(StatusEnum.normal.getCode());
        supplierInfo.setOperationUserId(user.getUserid());
        int flag = supplierInfoMapper.insert(supplierInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String delete(SupplierInfo supplierInfo, User user) {
        Date date = new Date();
        supplierInfo.setUpdateTime(date);
        supplierInfo.setStatus(StatusEnum.abnormal.getCode());
        supplierInfo.setOperationUserId(user.getUserid());
        int flag = supplierInfoMapper.deleteByPrimaryKey(supplierInfo);
        if (flag == 1) {
            return "删除成功";
        }
        return "删除失败";
    }
}
