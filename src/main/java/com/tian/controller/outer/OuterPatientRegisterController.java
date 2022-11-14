package com.tian.controller.outer;

import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientRegisterReq;
import com.tian.service.OuterPatientRegisterService;
import com.tian.utils.DateUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

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
        return outerPatientRegisterService.departmentList(outerPatientRegisterReq);
    }


    /**
     * 挂号类型
     */
    @GetMapping("/register/type")
    public CommonResult registerType(@RequestBody OuterPatientRegisterReq outerPatientRegisterReq) {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.registerTypeList(outerPatientRegisterReq);
    }

    /**
     * 科室下 某个挂号类型下  所有医生
     */
    @GetMapping("/doctor/list")
    public CommonResult doctorList(@RequestBody OuterPatientRegisterReq outerPatientRegisterReq) {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.doctorList(outerPatientRegisterReq);
    }

    /**
     * 确定医生后，再选择医生在预约时间段还有没有空位
     * 获取医生预约时间段 剩余空位
     *
     * @param doctorId     医生Id
     * @param registerDate 预约日期
     * @param timeSlot     早上还是下午
     * @return 返回已经预约情况
     */
    @GetMapping("/doctor/time/slot")
    public CommonResult doctorTimeSlotList(Integer doctorId, String registerDate, Integer timeSlot) throws ParseException {
        // TODO: 2022/10/28 参数校验
        return outerPatientRegisterService.doctorTimeSlotList(doctorId, DateUtil.parase(registerDate, DateUtil.DATEFORMATDAY), timeSlot);
    }
}
