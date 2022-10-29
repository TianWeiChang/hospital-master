package com.tian.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月27日 20:12
 * 处理手机号、身份证号码、邮箱  打马赛克
 */
public class PrivacyDimmer {
    private static final String OVERLAY = "****";
    private static final int START = 3;
    private static final int END = 7;

    /**
     * 139****0504
     * 处理手机号
     */
    public static String maskMobile(String content) {
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        return StringUtils.overlay(content, OVERLAY, START, 9);
    }

    /**
     * 过滤邮箱账号
     * 132****99308084911
     * 处理邮箱账号
     */
    public static String maskEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return "";
        }
        String at = "@";
        if (!email.contains(at)) {
            return email;
        }
        /**
         * 这里主要逻辑是需要保留邮箱的注册商 比如@qq.com
         */
        int length = StringUtils.indexOf(email, at);
        String content = StringUtils.substring(email, 0, length);
        String mask = StringUtils.overlay(content, OVERLAY, START, END);
        return mask + StringUtils.substring(email, length);
    }

    /**
     * 身份证打码操作
     * 132****99308084911
     * 处理身份证号
     */
    public static String maskIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return "";
        }
        return StringUtils.overlay(idCard, OVERLAY, START, 16);
    }

    public static void main(String[] args) {
        String phone = "18257461307";
        String email = "18257461307@qq.com";
        String cardId = "430321198005251517";

        //430****17
        System.out.println(maskIdCard(cardId));
        //182****07
        System.out.println(maskMobile(phone));
        //182****1307@qq.com
        System.out.println(maskEmail(email));
    }
}