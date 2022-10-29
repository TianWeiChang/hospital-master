package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.*;
import com.tian.service.DepartmentInfoService;
import com.tian.service.DoctorInfoService;
import com.tian.service.RegisteredTypeService;
import com.tian.utils.ReturnDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * 医生信息操作
 * 2022年10月12日
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Resource
    private DoctorInfoService doctorInfoService;
    @Resource
    private DepartmentInfoService departmentInfoService;
    @Resource
    private RegisteredTypeService registeredTypeService;

    /**
     * 查询医生
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object doctorList(DoctorInfo doctorInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<DoctorInfo> listAll = doctorInfoService.doctorList(doctorInfo);
        PageInfo<DoctorInfo> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }

    @RequestMapping("/doctorDepartment")
    @ResponseBody
    public Object doctorDepartment(DoctorInfo doctorInfo) {
        return doctorInfoService.doctorList(doctorInfo);
    }
    /**
     * 添加医生
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object addDoctor(DoctorInfo doctorInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        int count = doctorInfoService.count(doctorInfo);
        if (count == 0) {
            return doctorInfoService.addDoctor(doctorInfo, user);
        } else {
            return doctorInfo.getDoctorName() + "已存在";
        }
    }

    /**
     * 修改医生
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object editDoctor(DoctorInfo doctorInfo, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        return doctorInfoService.editDoctor(doctorInfo, user);
    }

    /**
     * 删除医生
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteDoctor(Integer doctorId) {
        boolean flag = doctorInfoService.checkCount(doctorId);
        if (flag) {
            return "该医生还有病人";
        } else {
            /*int i = doctorInfoService.deleteDoctor(doctorId);
            if (i == 1) {
                return "删除成功";
            } else {
                return "删除失败";
            }*/
            return "删除失败";
        }
    }

    /**
     * 查询科室
     */
    @RequestMapping("/findAllDepartments")
    @ResponseBody
    public Object findAllDepartments() {
        return departmentInfoService.departmentList(null);
    }

    /**
     * 查询类型
     */
    @RequestMapping("/findAllRegisteredtype")
    @ResponseBody
    public Object findAllRegisteredtype() {
        return registeredTypeService.registeredTypeList(null);
    }
}
