package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class PrescriptionPricing implements Serializable {
    private Integer id;

    private String drugName;
    /**
     * 请求参数携带的
     */
    private Integer drugId;

    private Integer patientRegisterId;

    private Integer drugCount;

    private  Integer type;

    private Integer price;

    private Integer total;

    private Integer paymentStatus;

    private Integer inspectStatus;

    private String inspectInstructions;

    private Integer operationUserId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPatientRegisterId() {
        return patientRegisterId;
    }

    public void setPatientRegisterId(Integer patientRegisterId) {
        this.patientRegisterId = patientRegisterId;
    }

    public Integer getDrugCount() {
        return drugCount;
    }

    public void setDrugCount(Integer drugCount) {
        this.drugCount = drugCount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(Integer inspectStatus) {
        this.inspectStatus = inspectStatus;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Integer operationUserId) {
        this.operationUserId = operationUserId;
    }

    public String getInspectInstructions() {
        return inspectInstructions;
    }

    public void setInspectInstructions(String inspectInstructions) {
        this.inspectInstructions = inspectInstructions;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugName=").append(drugName);
        sb.append(", patientRegisterId=").append(patientRegisterId);
        sb.append(", drugCount=").append(drugCount);
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", operationUserId=").append(operationUserId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}