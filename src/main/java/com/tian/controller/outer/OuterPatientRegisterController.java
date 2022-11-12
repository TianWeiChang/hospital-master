package com.tian.controller.outer;

import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientRegisterReq;
import com.tian.service.OuterPatientRegisterService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 挂号
     */
    @PostMapping("/register")
    public CommonResult register(@RequestBody OuterPatientRegisterReq outerPatientRegisterReq) {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.register(outerPatientRegisterReq);
    }

    /**
     * 科室列表
     */
    @PostMapping("/department/list")
    public CommonResult departmentList(@RequestBody OuterPatientRegisterReq outerPatientRegisterReq) {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.register(outerPatientRegisterReq);
    }


    /**
     * 挂号类型
     */
    @GetMapping("/register/type")
    public CommonResult registerType(@RequestBody OuterPatientRegisterReq outerPatientRegisterReq) {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.register(outerPatientRegisterReq);
    }

    /**
     * 科室下 某个挂号类型下  所有医生
     */
    @GetMapping("/doctor/list")
    public CommonResult doctorList(@RequestBody OuterPatientRegisterReq outerPatientRegisterReq) {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.register(outerPatientRegisterReq);
    }

}
