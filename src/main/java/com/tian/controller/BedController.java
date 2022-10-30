package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.BedInfo;
import com.tian.entity.OutpatientDepartmentChargeProject;
import com.tian.entity.User;
import com.tian.service.BedInfoService;
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
 * @date 2022年10月26日 14:03
 * <p>
 * 住院床位
 */
@Controller
@RequestMapping("/bed")
public class BedController {

    @Resource
    private BedInfoService bedInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object list(BedInfo bedInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<BedInfo> listAll = bedInfoService.list(bedInfo);
        PageInfo<BedInfo> pageInfo = new PageInfo<>(listAll);
        Map<String, Object> tableData = new HashMap<>(4);
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    @RequestMapping("/all")
    @ResponseBody
    public Object all(BedInfo bedInfo) {
        return bedInfoService.list(bedInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(BedInfo bedInfo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return bedInfoService.add(bedInfo, user);
    }
}
