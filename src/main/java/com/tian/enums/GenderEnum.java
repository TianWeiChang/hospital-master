package com.tian.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月21日 12:01
 * <p>
 * 性别枚举
 */
public enum GenderEnum {
    /**
     * 女
     */
    WOMAN(0, "女"),
    /**
     * 男
     */
    MAN(1, "男");

    private static Map<Integer, GenderEnum> genderEnumMap = new ConcurrentHashMap<>();

    static {
        genderEnumMap.put(WOMAN.code, WOMAN);
        genderEnumMap.put(MAN.code, MAN);
    }

    private int code;
    private String desc;

    GenderEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static GenderEnum valueOfCode(int code) {
        return genderEnumMap.get(code);
    }
}
