package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.User;
import com.tian.entity.WarehouseInfo;
import com.tian.service.WarehouseInfoService;
import com.tian.utils.ReturnDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 仓库信息管理
 * @createTime 2022年10月19日 22:24
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseInfoController {

    @Resource
    private WarehouseInfoService warehouseInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(WarehouseInfo warehuose, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<WarehouseInfo> listAll = warehouseInfoService.list(warehuose);
        PageInfo<WarehouseInfo> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }
    @RequestMapping("/all")
    public Object all(Model model) {
        List<WarehouseInfo> listAll = warehouseInfoService.list(null);
        model.addAttribute("selware",listAll);
        return "prescription_pricing";
    }
    @RequestMapping("/add")
    @ResponseBody
    public Object add(WarehouseInfo warehouseInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return warehouseInfoService.add(warehouseInfo, user);
    }
}
