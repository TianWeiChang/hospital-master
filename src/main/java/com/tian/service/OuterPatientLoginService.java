package com.tian.service;

import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientLoginReq;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 11:02
 */
public interface OuterPatientLoginService {
    /**
     * 手机端、微信端等外网 注册
     * @param outerPatientLoginReq 手机号、验证码
     * @return 登录是否
     */
    CommonResult<String> login( OuterPatientLoginReq outerPatientLoginReq);

    /**
     * 手机端、微信端等外网 注册
     * @param outerPatientLoginReq 手机号
     * @return 六位随机数
     */
    CommonResult<String> sendCode( OuterPatientLoginReq outerPatientLoginReq);
}
