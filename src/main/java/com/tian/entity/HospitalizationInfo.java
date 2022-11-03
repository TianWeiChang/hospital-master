package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class HospitalizationInfo implements Serializable {
    private Integer id;

    private Integer patientRegisterId;

    private Integer doctorId;

    private Integer bedInfoId;

    private Integer bond;

    private Integer operationUserId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String patientAddress;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientRegisterId() {
        return patientRegisterId;
    }

    public void setPatientRegisterId(Integer patientRegisterId) {
        this.patientRegisterId = patientRegisterId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getBedInfoId() {
        return bedInfoId;
    }

    public void setBedInfoId(Integer bedInfoId) {
        this.bedInfoId = bedInfoId;
    }

    public Integer getBond() {
        return bond;
    }

    public void setBond(Integer bond) {
        this.bond = bond;
    }

    public Integer getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Integer operationUserId) {
        this.operationUserId = operationUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress == null ? null : patientAddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientRegisterId=").append(patientRegisterId);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", bedInfoId=").append(bedInfoId);
        sb.append(", bond=").append(bond);
        sb.append(", operationUserId=").append(operationUserId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", patientAddress=").append(patientAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}