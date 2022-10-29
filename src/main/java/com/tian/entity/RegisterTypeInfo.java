package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class RegisterTypeInfo implements Serializable {
    private Integer id;

    private String registerTypeName;

    private Integer price;

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


    public String getRegisterTypeName() {
        return registerTypeName;
    }


    public void setRegisterTypeName(String registerTypeName) {
        this.registerTypeName = registerTypeName == null ? null : registerTypeName.trim();
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
        sb.append(", registerTypeName=").append(registerTypeName);
        sb.append(", price=").append(price);
        sb.append(", operationUserId=").append(operationUserId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}