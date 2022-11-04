package com.tian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.dto.DrugInfoDto;
import com.tian.entity.*;
import com.tian.service.*;
import com.tian.utils.ReturnDataUtil;
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
 * @date 2022年10月22日 16:45
 * 入库单
 */
@Controller
@RequestMapping("/storage/in/order")
public class StorageInOrderController {
    @Resource
    private SupplierInfoService supplierInfoService;
    @Resource
    private OperatorInfoService operatorInfoService;
    @Resource
    private WarehouseInfoService warehouseInfoService;
    @Resource
    private DrugInfoService drugInfoService;
    @Resource
    private StorageInOrderInfoService storageInOrderInfoService;

    @RequestMapping("/init/page")
    public Object initPage(Model model) {
        //供货商
        List<SupplierInfo> supplierInfoList = supplierInfoService.list(null);
        //经办人
        List<OperatorInfo> operatorInfoList = operatorInfoService.list(null);
        //仓库
        List<WarehouseInfo> warehouseInfoList = warehouseInfoService.list(null);

        model.addAttribute("selupp", supplierInfoList);
        model.addAttribute("selsku", operatorInfoList);
        model.addAttribute("selwar", warehouseInfoList);
        return "drugstore/storage_in_order_init";
    }

    /**
     * 查询药品清单
     */
    @RequestMapping("/drugInfoList")
    @ResponseBody
    public Object drugInfoList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        PageInfo<DrugInfoDto> pageInfo  = drugInfoService.list(null);
        Map<String, Object> drugstoresData = new HashMap<>();
        //这是layui要求返回的json数据格式
        drugstoresData.put("code", 0);
        drugstoresData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        drugstoresData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        drugstoresData.put("data", pageInfo.getList());
        return drugstoresData;
    }

    /**
     * 添加一条药品入库
     */
    @RequestMapping("/add")
    @ResponseBody
    public Integer add(StorageInOrderInfoDto storageInOrderInfoDto, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return storageInOrderInfoService.add(storageInOrderInfoDto, user);
    }

    /**
     * 添加一条药品入库
     */
    @RequestMapping("/storageSum")
    @ResponseBody
    public int storageSum(StorageInOrderInfoDto storageInOrderInfoDto) {
        StorageInOrderInfo record = new StorageInOrderInfo();
        record.setDrugId(storageInOrderInfoDto.getDrugInfoId());
        return storageInOrderInfoService.storageSum(record);
    }

    //库房药品查询
    @RequestMapping("/listPage")
    public Object selectdurg() {
        return "drugstore/c_selectDrug";
    }

    /**
     * 查询科室 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(StorageInOrderInfo storageInOrderInfo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<StorageInOrderInfoRespDto> listAll = storageInOrderInfoService.list(storageInOrderInfo);
        PageInfo<StorageInOrderInfoRespDto> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }
}
