package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.DrugTypeInfo;
import com.tian.entity.User;
import com.tian.service.DrugTypeInfoService;
import com.tian.utils.ReturnDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月20日 19:21
 * 药品分类
 */
@Controller
@RequestMapping("/drug/type")
public class DrugTypeController {
    @Resource
    private DrugTypeInfoService drugTypeInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(DrugTypeInfo drugTypeInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<DrugTypeInfo> listAll = drugTypeInfoService.list(drugTypeInfo);
        PageInfo<DrugTypeInfo> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(DrugTypeInfo drugTypeInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return drugTypeInfoService.add(drugTypeInfo, user);
    }

    /*@RequestMapping("/edit")
    @ResponseBody
    public Object edit(DrugTypeInfo drugTypeInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return drugTypeInfoService.edit(drugTypeInfo, user);
    }*/
}
