package com.tian.dto;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月04日 15:05
 * <p>
 * 药品字典列表展示
 */
public class DrugInfoDto {
        private Integer id;

        private String drugName;

        private String productAddress;

        private String unitName;

        private Integer price;

        private String drugTypeName;

        private Integer drugTypeId;

        private Integer productAddressId;

        private Integer unitId;

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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDrugTypeName() {
        return drugTypeName;
    }

    public void setDrugTypeName(String drugTypeName) {
        this.drugTypeName = drugTypeName;
    }

    public Integer getDrugTypeId() {
        return drugTypeId;
    }

    public void setDrugTypeId(Integer drugTypeId) {
        this.drugTypeId = drugTypeId;
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

    @Override
    public String toString() {
        return "DrugInfoDto{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", productAddress='" + productAddress + '\'' +
                ", unitName='" + unitName + '\'' +
                ", price=" + price +
                ", drugTypeName='" + drugTypeName + '\'' +
                ", drugTypeId=" + drugTypeId +
                ", productAddressId=" + productAddressId +
                ", unitId=" + unitId +
                '}';
    }
}

