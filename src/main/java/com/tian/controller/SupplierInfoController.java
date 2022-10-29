package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.SupplierInfo;
import com.tian.entity.User;
import com.tian.entity.WarehouseInfo;
import com.tian.service.SupplierInfoService;
import com.tian.service.WarehouseInfoService;
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
 * @date 2022年10月20日 21:27
 */
@Controller
@RequestMapping("/supplier")
public class SupplierInfoController {
    @Resource
    private SupplierInfoService supplierInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(SupplierInfo supplierInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SupplierInfo> listAll = supplierInfoService.list(supplierInfo);
        PageInfo<SupplierInfo> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(SupplierInfo supplierInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return supplierInfoService.add(supplierInfo, user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(SupplierInfo supplierInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return supplierInfoService.delete(supplierInfo, user);
    }
}
