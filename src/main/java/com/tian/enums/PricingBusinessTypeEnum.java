package com.tian.enums;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月31日 09:28
 * 划价日志类型
 */
public enum PricingBusinessTypeEnum {
    /**
     * 新增处方划价
     */
    ADD_PRESCRIPTION_PRICING(0, "处方划价"),
    /**
     * 编辑处方划价
     */
    EDIT_PRESCRIPTION_PRICING(0, "处方划价"),
    /**
     * 处方划价 填写病因
     */
    PRESCRIPTION_PRICING_PATHOGENY(0, "处方划价"),
    /**
     * 新增项目划价
     */
    ADD_PROJECT_PRICING(0, "处方划价"),
    /**
     * 编辑项目划价
     */
    EDIT_PROJECT_PRICING(0, "处方划价"),
    /**
     * 项目检查结果
     */
    PROJECT_PRICING_RESULT(0, "处方划价");

    private int code;
    private String msg;

    PricingBusinessTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
