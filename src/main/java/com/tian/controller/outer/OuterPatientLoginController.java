package com.tian.controller.outer;

import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientLoginReq;
import com.tian.dto.OuterPatientRegisterReq;
import com.tian.enums.ResultCode;
import com.tian.service.OuterPatientLoginService;
import com.tian.utils.StringUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 10:27
 *
 *  外网访问（登录、挂号）
 *
 */
@RestController
@RequestMapping("/out")
public class OuterPatientLoginController {
    @Resource
    private OuterPatientLoginService outerPatientRegisterService;


    /**
     * 发送短信验证码
     */
    @PostMapping("/send")
    public CommonResult sendMsg(@RequestBody OuterPatientLoginReq outerPatientLoginReq) {
        if (StringUtil.isEmpty(outerPatientLoginReq.getPhone())) {
            return CommonResult.failed(ResultCode.VALIDATE_FAILED);
        }
        return outerPatientRegisterService.sendCode(outerPatientLoginReq);
    }

    /**
     * 患者使用使用手机号码+验证码 登录
     * 返回 token 后期的请求必须带着 token
     */
    @PostMapping("/login")
    public CommonResult login(@RequestBody OuterPatientLoginReq outerPatientLoginReq) {
        if (StringUtil.isEmpty(outerPatientLoginReq.getCode())) {
            return CommonResult.failed(ResultCode.VALIDATE_FAILED);
        }
        if (StringUtil.isEmpty(outerPatientLoginReq.getPhone())) {
            return CommonResult.failed(ResultCode.VALIDATE_FAILED);
        }
        return outerPatientRegisterService.login(outerPatientLoginReq);
    }
}
