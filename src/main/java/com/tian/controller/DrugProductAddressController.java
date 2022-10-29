package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.DepartmentInfo;
import com.tian.entity.DrugProductAddressInfo;
import com.tian.entity.User;
import com.tian.service.DrugProductAddressInfoService;
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
 * @date 2022年10月20日 19:03
 * 药品产地信息
 */
@Controller
@RequestMapping("/drug/product/address")
public class DrugProductAddressController {

    @Resource
    private DrugProductAddressInfoService drugProductAddressInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(DrugProductAddressInfo drugProductAddressInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<DrugProductAddressInfo> drugProductAddressInfoList = drugProductAddressInfoService.list(drugProductAddressInfo);
        PageInfo<DrugProductAddressInfo> pageInfo = new PageInfo<>(drugProductAddressInfoList);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(DrugProductAddressInfo drugProductAddressInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return drugProductAddressInfoService.add(drugProductAddressInfo, user);
    }
}
