package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.BedInfo;
import com.tian.entity.ChargeTypeInfo;
import com.tian.entity.User;
import com.tian.service.ChargeTypeInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月26日 14:43
 * 收费类型
 */
@Controller
@RequestMapping("/charge/type")
public class ChargeTypeInfoController {

    @Resource
    private ChargeTypeInfoService chargeTypeInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(ChargeTypeInfo chargeTypeInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ChargeTypeInfo> listAll = chargeTypeInfoService.list(chargeTypeInfo);
        PageInfo<ChargeTypeInfo> pageInfo = new PageInfo<>(listAll);
        Map<String, Object> tableData = new HashMap<>(4);
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    @RequestMapping("/all")
    @ResponseBody
    public Object all(ChargeTypeInfo chargeTypeInfo) {
        return chargeTypeInfoService.list(chargeTypeInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(ChargeTypeInfo chargeTypeInfo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return chargeTypeInfoService.add(chargeTypeInfo, user);
    }
}
