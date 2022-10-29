package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class StorageInOrderInfo implements Serializable {
    private Integer id;

    private String warehouseName;

    private Integer drugTypeId;

    private String drugName;

    private Integer drugId;

    private String supplierName;

    private String operatorName;

    private Integer wholeSalePrice;

    private Integer price;

    private Integer count;

    private Integer unit;

    private Date productDate;

    private Date validDate;

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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    public Integer getDrugTypeId() {
        return drugTypeId;
    }

    public void setDrugTypeId(Integer drugTypeId) {
        this.drugTypeId = drugTypeId;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Integer getWholeSalePrice() {
        return wholeSalePrice;
    }

    public void setWholeSalePrice(Integer wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", drugTypeId=").append(drugTypeId);
        sb.append(", drugName=").append(drugName);
        sb.append(", drugId=").append(drugId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", wholeSalePrice=").append(wholeSalePrice);
        sb.append(", price=").append(price);
        sb.append(", count=").append(count);
        sb.append(", unit=").append(unit);
        sb.append(", productDate=").append(productDate);
        sb.append(", validDate=").append(validDate);
        sb.append(", operationUserId=").append(operationUserId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}