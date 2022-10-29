package com.tian.enums;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 医生类型 住院部  门诊部
 * @createTime 2022年10月19日 20:45
 */
public enum DoctorType {
    MEN_ZHEN(0, "门诊部"),
    ZHU_YUAN(1, "住院部");

    private int type;
    private String name;

    DoctorType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
