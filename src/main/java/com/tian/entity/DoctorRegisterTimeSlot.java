package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class DoctorRegisterTimeSlot implements Serializable {
    private Integer id;

    private Integer doctorId;

    private Integer registerTimeSlotId;

    private Integer registerTotal;

    private Date registerDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getRegisterTimeSlotId() {
        return registerTimeSlotId;
    }

    public void setRegisterTimeSlotId(Integer registerTimeSlotId) {
        this.registerTimeSlotId = registerTimeSlotId;
    }

    public Integer getRegisterTotal() {
        return registerTotal;
    }

    public void setRegisterTotal(Integer registerTotal) {
        this.registerTotal = registerTotal;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", registerTimeSlotId=").append(registerTimeSlotId);
        sb.append(", registerTotal=").append(registerTotal);
        sb.append(", registerDate=").append(registerDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}