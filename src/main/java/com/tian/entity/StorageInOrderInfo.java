package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class StorageInOrderInfo implements Serializable {
    private Integer id;

    private Integer drugInfoId;

    private Integer warehouseInfoId;

    private Integer supplierInfoId;

    private Integer operatorInfoId;

    private Integer wholeSalePrice;

    private Integer count;

    private Date productDate;

    private Date validDate;

    private String batchNo;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrugInfoId() {
        return drugInfoId;
    }

    public void setDrugInfoId(Integer drugInfoId) {
        this.drugInfoId = drugInfoId;
    }

    public Integer getWarehouseInfoId() {
        return warehouseInfoId;
    }

    public void setWarehouseInfoId(Integer warehouseInfoId) {
        this.warehouseInfoId = warehouseInfoId;
    }

    public Integer getSupplierInfoId() {
        return supplierInfoId;
    }

    public void setSupplierInfoId(Integer supplierInfoId) {
        this.supplierInfoId = supplierInfoId;
    }

    public Integer getOperatorInfoId() {
        return operatorInfoId;
    }

    public void setOperatorInfoId(Integer operatorInfoId) {
        this.operatorInfoId = operatorInfoId;
    }

    public Integer getWholeSalePrice() {
        return wholeSalePrice;
    }

    public void setWholeSalePrice(Integer wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugInfoId=").append(drugInfoId);
        sb.append(", warehouseInfoId=").append(warehouseInfoId);
        sb.append(", supplierInfoId=").append(supplierInfoId);
        sb.append(", operatorInfoId=").append(operatorInfoId);
        sb.append(", wholeSalePrice=").append(wholeSalePrice);
        sb.append(", count=").append(count);
        sb.append(", productDate=").append(productDate);
        sb.append(", validDate=").append(validDate);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}