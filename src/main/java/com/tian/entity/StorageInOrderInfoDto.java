package com.tian.entity;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月22日 18:55
 */
public class StorageInOrderInfoDto {
    /**
     * 供货商
     */
    private Integer supplierId;
    private String supplierName;
    /**
     * 经办人
     */
    private Integer operatorId;
    private String operatorName;
    /**
     * 仓库
     */
    private Integer warehouseId;
    private String warehouseName;

    /**
     * 药名
     */
    private String drugstoreName;
    /**
     * 售价
     */
    private Integer tradePrice;
    /**
     * 批发价
     */
    private Integer sellingPrice;
    /**
     * 批次号
     */
    private String batch;
    /**
     * 入库数量
     */
    private Integer storageCount;
    /**
     * 药品信息id
     */
    private Integer drugInfoId;
    /**
     * 生产日期
     */
    private String productDateStr;
    /**
     * 有效期
     */
    private String validDateStr;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getDrugstoreName() {
        return drugstoreName;
    }

    public void setDrugstoreName(String drugstoreName) {
        this.drugstoreName = drugstoreName;
    }

    public Integer getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Integer tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getStorageCount() {
        return storageCount;
    }

    public void setStorageCount(Integer storageCount) {
        this.storageCount = storageCount;
    }

    public Integer getDrugInfoId() {
        return drugInfoId;
    }

    public void setDrugInfoId(Integer drugInfoId) {
        this.drugInfoId = drugInfoId;
    }

    public String getProductDateStr() {
        return productDateStr;
    }

    public void setProductDateStr(String productDateStr) {
        this.productDateStr = productDateStr;
    }

    public String getValidDateStr() {
        return validDateStr;
    }

    public void setValidDateStr(String validDateStr) {
        this.validDateStr = validDateStr;
    }
}
