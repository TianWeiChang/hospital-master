package com.tian.service.impl;

import com.tian.entity.HospitalizationInfo;
import com.tian.mapper.HospitalizationInfoMapper;
import com.tian.service.HospitalizationInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月30日 17:03
 * <p>
 * 住院信息
 */
@Service
public class HospitalizationInfoServiceImpl implements HospitalizationInfoService {
    @Resource
    private HospitalizationInfoMapper hospitalizationInfoMapper;

    @Override
    public List<HospitalizationInfo> list(HospitalizationInfo hospitalizationInfo) {
        return hospitalizationInfoMapper.selectAll();
    }

    @Override
    public String add(HospitalizationInfo hospitalizationInfo) {

        int flag = hospitalizationInfoMapper.insert(hospitalizationInfo);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
}
