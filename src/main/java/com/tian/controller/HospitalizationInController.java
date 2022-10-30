package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.HospitalizationInfo;
import com.tian.service.HospitalizationInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月30日 16:38
 * <p>
 * 住院管理：入院管理
 */

@Controller
@RequestMapping("/hospitalization/in")
public class HospitalizationInController {

    @Resource
    private HospitalizationInfoService hospitalizationInfoService;

    /**
     * 页面初始化
     */
    @RequestMapping("/initPage")
    @ResponseBody
    public Object initPage(Integer page, Integer limit, String userName) {
        PageHelper.startPage(page, limit);
        HospitalizationInfo hospitalizationInfo = new HospitalizationInfo();
        List<HospitalizationInfo> hospitalizationInfoList = hospitalizationInfoService.list(hospitalizationInfo);
        PageInfo<HospitalizationInfo> pageInfo = new PageInfo<>(hospitalizationInfoList);
        Map<String, Object> tableData = new HashMap<>(8);
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }
}
