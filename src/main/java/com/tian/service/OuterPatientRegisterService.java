package com.tian.service;

import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientRegisterReq;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 18:25
 *
 *   外网挂号
 *
 */
public interface OuterPatientRegisterService {
    /**
     * 外网挂号
     *
     * @param outerPatientRegisterReq 请求参数
     * @return 挂号是否成功
     */
    CommonResult register(OuterPatientRegisterReq outerPatientRegisterReq);
}
