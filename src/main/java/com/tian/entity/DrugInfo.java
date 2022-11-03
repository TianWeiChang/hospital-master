package com.tian.entity;

import java.io.Serializable;

public class DrugInfo implements Serializable {
    private Integer id;

    private String drugName;

    private Integer productAddressId;

    private Integer unitId;

    private Integer price;

    private Integer drugTypeId;

    private Integer status;

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

    public Integer getProductAddressId() {
        return productAddressId;
    }

    public void setProductAddressId(Integer productAddressId) {
        this.productAddressId = productAddressId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugName=").append(drugName);
        sb.append(", productAddressId=").append(productAddressId);
        sb.append(", unitId=").append(unitId);
        sb.append(", price=").append(price);
        sb.append(", drugTypeId=").append(drugTypeId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}