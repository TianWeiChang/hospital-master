package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.OperatorInfo;
import com.tian.entity.User;
import com.tian.service.OperatorInfoService;
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
 * 经办人
 */
@Controller
@RequestMapping("/operator")
public class OperatorInfoController {

    @Resource
    private OperatorInfoService operatorInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(OperatorInfo operatorInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OperatorInfo> listAll = operatorInfoService.list(operatorInfo);
        PageInfo<OperatorInfo> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(OperatorInfo operatorInfo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return operatorInfoService.add(operatorInfo, user);
    }
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(OperatorInfo operatorInfo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return operatorInfoService.update(operatorInfo, user);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(OperatorInfo operatorInfo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return operatorInfoService.delete(operatorInfo, user);
    }
}
