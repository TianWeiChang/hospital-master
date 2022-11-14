package com.tian.entity;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月14日 10:21
 */
public class RegisterTimeVO {
    /**
     * 已约人数
     */
    private Integer registerTotal;
    /**
     * 预约人数限制
     */
    private Integer max;
    /**
     * 预约时间
     */
    private String registerDate;

    private Integer doctorRegisterTimeSlotId;

    public Integer getRegisterTotal() {
        return registerTotal;
    }

    public void setRegisterTotal(Integer registerTotal) {
        this.registerTotal = registerTotal;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getDoctorRegisterTimeSlotId() {
        return doctorRegisterTimeSlotId;
    }

    public void setDoctorRegisterTimeSlotId(Integer doctorRegisterTimeSlotId) {
        this.doctorRegisterTimeSlotId = doctorRegisterTimeSlotId;
    }
}
