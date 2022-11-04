package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.tian.entity.DrugInfo;
import com.tian.entity.User;
import com.tian.service.DrugInfoService;
import com.tian.utils.ReturnDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 23:16
 * <p>
 * 药品字典信息
 */
@Controller
@RequestMapping("/drug/info")
public class DrugInfoController {
    @Resource
    private DrugInfoService drugInfoService;

    /**
     * 查询 药品信息 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(DrugInfo drugInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return ReturnDataUtil.getTableData(drugInfoService.list(drugInfo));
    }


    /**
     * 添加药品信息
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(DrugInfo drugInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return drugInfoService.add(drugInfo, user);
    }

    /**
     * 修改药品信息
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(DrugInfo drugInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return drugInfoService.edit(drugInfo, user);
    }

    @RequestMapping("/productAddress")
    @ResponseBody
    public Object productAddress() {
        return drugInfoService.productAddress();
    }

    @RequestMapping("/drugUnit")
    @ResponseBody
    public Object drugUnit() {
        return drugInfoService.drugUnit();
    }

    @RequestMapping("/drugType")
    @ResponseBody
    public Object drugType() {
        return drugInfoService.drugType();
    }
}