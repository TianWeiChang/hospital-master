package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.RegisterTypeInfo;
import com.tian.entity.RegisteredType;
import com.tian.entity.User;
import com.tian.service.RegisteredTypeService;
import com.tian.utils.ReturnDataUtil;
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
 * @description 挂号类型
 * @createTime 2022年10月19日 15:52
 */
@Controller
@RequestMapping("/registerType")
public class RegisterTypeController {

    @Resource
    private RegisteredTypeService registeredTypeList;

    /**
     * 挂号类型信息列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object registeredTypeList(RegisterTypeInfo registerTypeInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<RegisterTypeInfo> listAll = registeredTypeList.registeredTypeList(registerTypeInfo);
        PageInfo pageInfo = new PageInfo(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    /**
     * 添加挂号类型
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(RegisterTypeInfo registerTypeInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return registeredTypeList.add(registerTypeInfo, user);
    }

    /**
     * 修改科室
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(RegisterTypeInfo registerTypeInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return registeredTypeList.edit(registerTypeInfo, user);
    }
}
