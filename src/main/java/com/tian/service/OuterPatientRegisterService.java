package com.tian.service;

import com.alipay.api.AlipayApiException;
import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientRegisterReq;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 18:25
 * <p>
 * 外网挂号
 */
public interface OuterPatientRegisterService {
    /**
     * 外网挂号
     *
     * @param outerPatientRegisterReq 请求参数
     * @return 挂号是否成功
     */
    CommonResult register(OuterPatientRegisterReq outerPatientRegisterReq);

    /**
     * 科室列表
     */
    CommonResult departmentList(OuterPatientRegisterReq outerPatientRegisterReq);

    /**
     * 医生列表
     */
    CommonResult doctorList(OuterPatientRegisterReq outerPatientRegisterReq);

    /**
     * 挂号类型列表
     */
    CommonResult registerTypeList(OuterPatientRegisterReq outerPatientRegisterReq);

    /**
     * 创建预支付单
     *
     * @param id 挂号id
     * @return 生成二维码的内容
     */
    CommonResult<String> preCreateOrder(Integer id) throws AlipayApiException;

    CommonResult payNotify(String tradeNo,String payStatus);

    void payOrderQuery();
}
