package com.tian.utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description TODO
 * @createTime 2022年10月19日 20:27
 */
public class ReturnDataUtil {

    public static Map<String, Object> getTableData(PageInfo pageInfo) {
        Map<String, Object> tableData = new HashMap<>(8);
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        return tableData;
    }
}
