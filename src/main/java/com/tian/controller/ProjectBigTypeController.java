package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.PrescriptionPricing;
import com.tian.entity.ProjectBigType;
import com.tian.entity.User;
import com.tian.service.OutpatientDepartmentChargeProjectService;
import com.tian.service.ProjectBigTypeService;
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
 * @date 2022年10月25日 15:54
 * <p>
 * 项目大类
 */
@Controller
@RequestMapping("/project/big/type")
public class ProjectBigTypeController {

    @Resource
    private ProjectBigTypeService projectBigTypeService;

    /**
     *
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(ProjectBigType projectBigType, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ProjectBigType> listAll = projectBigTypeService.list(projectBigType);
        PageInfo<ProjectBigType> pageInfo = new PageInfo<>(listAll);
        Map<String, Object> tableData = new HashMap<>(4);
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    /**
     * 查询
     */
    @RequestMapping("/all")
    @ResponseBody
    public Object all() {
        return projectBigTypeService.list(null);
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(ProjectBigType projectBigType, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return projectBigTypeService.add(projectBigType, user);
    }
}
