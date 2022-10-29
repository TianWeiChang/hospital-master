package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.OutpatientDepartmentChargeProject;
import com.tian.entity.ProjectBigType;
import com.tian.entity.User;
import com.tian.service.OutpatientDepartmentChargeProjectService;
import com.tian.service.ProjectBigTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @date 2022年10月25日 17:35
 * 门诊收费项目
 */
@Controller
@RequestMapping("/outpatient/department/charge/project")
public class OutpatientDepartmentChargeProjectController {

    @Resource
    private OutpatientDepartmentChargeProjectService outpatientDepartmentChargeProjectService;

    /**
     * 查询门诊收费项目列表
     */
    @RequestMapping("/list/{projectType}")
    @ResponseBody
    public Object list(@PathVariable("projectType") Integer projectType, OutpatientDepartmentChargeProject outpatientDepartmentChargeProject, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        outpatientDepartmentChargeProject.setProjectType(projectType);
        List<OutpatientDepartmentChargeProject> listAll = outpatientDepartmentChargeProjectService.list(outpatientDepartmentChargeProject);
        PageInfo<OutpatientDepartmentChargeProject> pageInfo = new PageInfo<>(listAll);
        Map<String, Object> tableData = new HashMap<>(4);
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }
    @RequestMapping("/list/all")
    @ResponseBody
    public Object listAll( OutpatientDepartmentChargeProject outpatientDepartmentChargeProject, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<OutpatientDepartmentChargeProject> listAll = outpatientDepartmentChargeProjectService.list(outpatientDepartmentChargeProject);
        PageInfo<OutpatientDepartmentChargeProject> pageInfo = new PageInfo<>(listAll);
        Map<String, Object> tableData = new HashMap<>(4);
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    /**
     * 添加门诊收费项目
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(OutpatientDepartmentChargeProject outpatientDepartmentChargeProject, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return outpatientDepartmentChargeProjectService.add(outpatientDepartmentChargeProject, user);
    }
}