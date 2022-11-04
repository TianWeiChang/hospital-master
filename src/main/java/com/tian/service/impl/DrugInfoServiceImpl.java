package com.tian.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.tian.dto.DrugInfoDto;
import com.tian.entity.*;
import com.tian.enums.StatusEnum;
import com.tian.mapper.DrugInfoMapper;
import com.tian.mapper.DrugProductAddressInfoMapper;
import com.tian.mapper.DrugTypeInfoMapper;
import com.tian.mapper.UnitInfoMapper;
import com.tian.mq.RabbitMqClient;
import com.tian.service.DrugInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 22:53
 * 药品信息
 */
@Service
public class DrugInfoServiceImpl implements DrugInfoService {
    @Resource
    private DrugInfoMapper drugInfoMapper;
    @Resource
    private UnitInfoMapper unitInfoMapper;
    @Resource
    private DrugTypeInfoMapper drugTypeInfoMapper;
    @Resource
    private DrugProductAddressInfoMapper drugProductAddressInfoMapper;
    @Resource
    private RabbitMqClient rabbitMqClient;

    @Override
    public PageInfo<DrugInfoDto> list(DrugInfo drugInfo) {
        List<DrugInfoDto> drugInfoList = drugInfoMapper.selectPage(drugInfo);
        return new PageInfo<>(drugInfoList);
    }

    @Override
    public String add(DrugInfo drugInfo, User user) {
        int count = drugInfoMapper.count(drugInfo);
        if (count > 0) {
            return drugInfo.getDrugName() + "已存在";
        }
        drugInfo.setPrice(drugInfo.getPrice());
        drugInfo.setStatus(StatusEnum.normal.getCode());
        int flag = drugInfoMapper.insert(drugInfo);
        if (flag == 1) {
            DrugInfoOperationLog drugInfoOperationLog = new DrugInfoOperationLog();
            drugInfoOperationLog.setCreateTime(new Date());
            drugInfoOperationLog.setOperationUserId(user.getUserid());
            drugInfoOperationLog.setBeforeContent(null);
            drugInfoOperationLog.setAfterContent(JSON.toJSONString(drugInfo));
            rabbitMqClient.sendDrugInfoOperationLog(drugInfoOperationLog);
//            asyncService.executeAsyncDrugInfoOperationLog(new Date(), user.getUserid(), null, JSON.toJSONString(drugInfo));
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String edit(DrugInfo drugInfo, User user) {
        DrugInfo drugInfoOld = drugInfoMapper.selectByPrimaryKey(drugInfo.getId());
        Date date = new Date();
        drugInfoOld.setDrugName(drugInfo.getDrugName());
        drugInfoOld.setPrice(drugInfo.getPrice());
        drugInfoOld.setUnitId(drugInfo.getUnitId());
        drugInfoOld.setDrugTypeId(drugInfo.getDrugTypeId());
        int flag = drugInfoMapper.updateByPrimaryKey(drugInfoOld);
        if (flag == 1) {
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String delete(Integer id, User user) {
        DrugInfo drugInfoOld = drugInfoMapper.selectByPrimaryKey(id);
        Date date = new Date();
        int flag = drugInfoMapper.deleteByPrimaryKey(drugInfoOld.getId());
        if (flag == 1) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public List<DrugProductAddressInfo> productAddress() {
        return drugProductAddressInfoMapper.selectList(null);
    }

    @Override
    public List<UnitInfo> drugUnit() {
        return unitInfoMapper.selectAll(null);
    }

    @Override
    public List<DrugTypeInfo> drugType() {
        return drugTypeInfoMapper.selectAll(null);
    }
}
