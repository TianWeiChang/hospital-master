package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.DepartmentInfo;
import com.tian.entity.User;
import com.tian.service.DepartmentInfoService;
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
 *  科室
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentInfoService departmentInfoService;

    /**
     * 查询科室 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(DepartmentInfo departmentInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<DepartmentInfo> listAll = departmentInfoService.departmentList(departmentInfo);
        PageInfo<DepartmentInfo> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    /**
     * 添加科室
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(DepartmentInfo departmentInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return departmentInfoService.add(departmentInfo, user);
    }

    /**
     * 修改科室
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(DepartmentInfo departmentInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return departmentInfoService.edit(departmentInfo, user);
    }
}
