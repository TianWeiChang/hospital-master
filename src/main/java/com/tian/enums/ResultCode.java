package com.tian.enums;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 11:11
 * <p>
 * 枚举了一些常用API操作码
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAILED(500, "操作失败"),
    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * token过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 没权限
     */
    FORBIDDEN(403, "没有相关权限");
    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}