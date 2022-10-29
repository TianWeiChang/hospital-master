package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class OutpatientDepartmentChargeProject implements Serializable {
    private Integer id;

    private String outpatientDepartmentProjectName;

    private Integer price;

    private String unitName;

    private Integer unitId;

    private Integer inspect;

    private Integer projectType;

    private Integer projectBigTypeId;

    private String projectBigTypeName;

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

    public String getOutpatientDepartmentProjectName() {
        return outpatientDepartmentProjectName;
    }

    public void setOutpatientDepartmentProjectName(String outpatientDepartmentProjectName) {
        this.outpatientDepartmentProjectName = outpatientDepartmentProjectName == null ? null : outpatientDepartmentProjectName.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getInspect() {
        return inspect;
    }

    public void setInspect(Integer inspect) {
        this.inspect = inspect;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getProjectBigTypeId() {
        return projectBigTypeId;
    }

    public void setProjectBigTypeId(Integer projectBigTypeId) {
        this.projectBigTypeId = projectBigTypeId;
    }

    public String getProjectBigTypeName() {
        return projectBigTypeName;
    }

    public void setProjectBigTypeName(String projectBigTypeName) {
        this.projectBigTypeName = projectBigTypeName == null ? null : projectBigTypeName.trim();
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
        sb.append(", outpatientDepartmentProjectName=").append(outpatientDepartmentProjectName);
        sb.append(", price=").append(price);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitId=").append(unitId);
        sb.append(", inspect=").append(inspect);
        sb.append(", projectBigTypeId=").append(projectBigTypeId);
        sb.append(", projectBigTypeName=").append(projectBigTypeName);
        sb.append(", operationUserId=").append(operationUserId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}