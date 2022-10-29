package com.tian.controller;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月27日 20:27
 */
@Controller
@RequestMapping("/out")
public class TestController {

    @RequiresGuest
    @RequestMapping("/index")
    @ResponseBody
    public Object test() {
        Map<String, Object> tableData = new HashMap<>(4);
        tableData.put("code", 0);
        tableData.put("msg", "");
        return tableData;
    }
}
