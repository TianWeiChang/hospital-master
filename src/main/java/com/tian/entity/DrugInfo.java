package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class DrugInfo implements Serializable {
    private Integer id;

    private String drugName;

    private String productAddress;

    private Date productTime;

    //显示用
    private Integer number;

    private Integer price;

    private Integer operationUserId;

    private Integer unit;

    private String unitName;

    private Integer drugTypeId;

    private String drugTypeName;

    private Integer status;

    private Date createTime;

    private Date updateTime;

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
        this.drugName = drugName;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Integer operationUserId) {
        this.operationUserId = operationUserId;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getDrugTypeId() {
        return drugTypeId;
    }

    public void setDrugTypeId(Integer drugTypeId) {
        this.drugTypeId = drugTypeId;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDrugTypeName() {
        return drugTypeName;
    }

    public void setDrugTypeName(String drugTypeName) {
        this.drugTypeName = drugTypeName;
    }

    @Override
    public String toString() {
        return "DrugInfo{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", productAddress='" + productAddress + '\'' +
                ", productTime=" + productTime +
                ", number=" + number +
                ", price=" + price +
                ", operationUserId=" + operationUserId +
                ", unit=" + unit +
                ", unitName=" + unitName +
                ", drugTypeId=" + drugTypeId +
                ", drugTypeName=" + drugTypeName +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}