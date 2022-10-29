package com.tian.controller.outer;

import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientRegisterReq;
import com.tian.service.OuterPatientRegisterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 18:12
 * <p>
 * 外网预约挂号
 */
@RestController
@RequestMapping("/out")
public class OuterPatientRegisterController {

    @Resource
    private OuterPatientRegisterService outerPatientRegisterService;

    @PostMapping("/register")
    public CommonResult register(@RequestBody OuterPatientRegisterReq outerPatientRegisterReq) {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.register(outerPatientRegisterReq);
    }
}
