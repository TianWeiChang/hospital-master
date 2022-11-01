package com.tian.mq;

import java.util.Date;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月31日 08:39
 */
public class Message<T> {

    private  T data;

    private Date sendTime;

    private Integer doctorId;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Message(T data, Date sendTime, Integer doctorId) {
        this.data = data;
        this.sendTime = sendTime;
        this.doctorId = doctorId;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "data=" + data +
                ", sendTime=" + sendTime +
                ", doctorId=" + doctorId +
                '}';
    }
}
