package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.entity.PrescriptionPricing;
import com.tian.entity.User;
import com.tian.entity.WarehouseInfo;
import com.tian.service.PrescriptionPricingService;
import com.tian.service.WarehouseInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @date 2022年10月25日 11:52
 */
@Controller
@RequestMapping("/project/pricing")
public class ProjectPricingController {
    @Resource
    private WarehouseInfoService warehouseInfoService;
    @Resource
    private PrescriptionPricingService prescriptionPricingService;

    /**
     * 进入处方页面 初始化页面
     */
    @RequestMapping("/initPage")
    public Object initPage(Model model) {
        //查询所有药房
        List<WarehouseInfo> warehouseInfoList = warehouseInfoService.list(null);
        model.addAttribute("selware", warehouseInfoList);
        return "cao/project_pricing";
    }

    /**
     * 查询该用户所有的处方
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer type, Integer page, Integer limit) {
        PrescriptionPricing prescriptionPricing = new PrescriptionPricing();
        prescriptionPricing.setType(type);
        List<PrescriptionPricing> prescriptionPricingList = prescriptionPricingService.list(prescriptionPricing);
        PageHelper.startPage(page, limit);
        PageInfo<PrescriptionPricing> pageInfo = new PageInfo<>(prescriptionPricingList);

        Map<String, Object> tableData = new HashMap<>();
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    /**
     * 查询该用户所有的处方
     */
    @RequestMapping("/query/count/registerId")
    @ResponseBody
    public Object queryCountByDrugId(Integer registerId, String drugName) {
        return prescriptionPricingService.queryCountByDrugId(registerId, drugName);
    }

    /**
     * 添加处方药品
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(PrescriptionPricing prescriptionPricing, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        try {
            return prescriptionPricingService.add(prescriptionPricing, user);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 添加处方药品
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(PrescriptionPricing prescriptionPricing, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        try {
            return prescriptionPricingService.edit(prescriptionPricing, user);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 添加处方药品
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(PrescriptionPricing prescriptionPricing, HttpServletRequest request) {
        //获取用户登陆id根据不同的用户有不停菜单
        User user = (User) request.getSession().getAttribute("user");
        try {
            return prescriptionPricingService.delete(prescriptionPricing, user);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
