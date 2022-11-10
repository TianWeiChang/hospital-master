package com.tian.entity;

import com.tian.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class StorageInOrderInfoRespDto implements Serializable {
    private Integer id;

    private String batchNo;

    private String warehouseName;

    private Integer drugTypeId;

    private String drugTypeName;

    private String drugName;

    private Integer drugId;

    private String supplierName;

    private String operatorName;

    private Integer wholeSalePrice;

    private Integer price;

    private Integer count;

    private Integer unit;

    private String unitName;

    private Date productDate;

    private String productDateStr;

    private String productAddress;

    private Date validDate;

    private String validDateStr;

    private Integer operationUserId;

    private Integer status;

    private Date createTime;

    private String createTimeStr;

    private Date updateTime;

    private String updateTimeStr;

    private static final long serialVersionUID = 1L;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

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

    public String getDrugTypeName() {
        return drugTypeName;
    }

    public void setDrugTypeName(String drugTypeName) {
        this.drugTypeName = drugTypeName;
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

    public String getProductDateStr() {
        return DateUtil.format(productDate,DateUtil.DATEFORMATDAY);
    }

    public void setProductDateStr(String productDateStr) {
        this.productDateStr = productDateStr;
    }

    public String getValidDateStr() {
        return DateUtil.format(validDate,DateUtil.DATEFORMATDAY);
    }

    public void setValidDateStr(String validDateStr) {
        this.validDateStr = validDateStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }
}