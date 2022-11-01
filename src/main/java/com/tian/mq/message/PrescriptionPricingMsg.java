package com.tian.mq.message;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月31日 08:55
 * 划价部分医生操作日志落库
 */
public class PrescriptionPricingMsg<T> implements Serializable {
    /**
     * 病人id
     */
    private Integer patientId;
    /**
     * 业务类型
     * 1、新增处方划价
     * 2、修改处方划价
     * 3、新增项目划价
     * 4、修改项目划价
     */
    private Integer businessType;
    /**
     * 医生id
     */
    private Integer doctorId;
    /**
     * 当前时间
     */
    private Date currTime;

    private T data;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Date getCurrTime() {
        return currTime;
    }

    public void setCurrTime(Date currTime) {
        this.currTime = currTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PrescriptionPricingMsg{" +
                "patientId=" + patientId +
                ", businessType=" + businessType +
                ", doctorId=" + doctorId +
                ", currTime=" + currTime +
                ", data=" + data +
                '}';
    }
}
