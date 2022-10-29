package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.SupplierInfo;
import com.tian.entity.UnitInfo;
import com.tian.entity.User;
import com.tian.service.UnitInfoService;
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
 * @date 2022年10月20日 22:29
 * 单位
 */
@Controller
@RequestMapping("/unit")
public class UnitInfoController {
    @Resource
    private UnitInfoService unitInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(UnitInfo unitInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<UnitInfo> listAll = unitInfoService.list(unitInfo);
        PageInfo<UnitInfo> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(UnitInfo unitInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return unitInfoService.add(unitInfo, user);
    }

}
