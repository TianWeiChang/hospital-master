package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class PatientRegister implements Serializable {
    private Integer id;

    private Integer patientId;

    private String patientName;

    private String pathogeny;

    private String inspectInstructions;

    private Integer doctorId;

    private Integer departmentId;

    private Integer registerTypeId;

    private Integer operationUserId;

    private Integer status;
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    private Integer date;

    private static final long serialVersionUID = 1L;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPathogeny() {
        return pathogeny;
    }

    public void setPathogeny(String pathogeny) {
        this.pathogeny = pathogeny;
    }

    public String getInspectInstructions() {
        return inspectInstructions;
    }

    public void setInspectInstructions(String inspectInstructions) {
        this.inspectInstructions = inspectInstructions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRegisterTypeId() {
        return registerTypeId;
    }

    public void setRegisterTypeId(Integer registerTypeId) {
        this.registerTypeId = registerTypeId;
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

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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

    @Override
    public String toString() {
        return "PatientRegister{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", pathogeny='" + pathogeny + '\'' +
                ", inspectInstructions='" + inspectInstructions + '\'' +
                ", doctorId=" + doctorId +
                ", departmentId=" + departmentId +
                ", registerTypeId=" + registerTypeId +
                ", operationUserId=" + operationUserId +
                ", status=" + status +
                ", payStatus=" + payStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", date=" + date +
                '}';
    }
}