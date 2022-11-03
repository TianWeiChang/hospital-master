package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

public class DrugInfoOperationLog implements Serializable {
    private Integer id;

    private Integer operationUserId;

    private String beforeContent;

    private String afterContent;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Integer operationUserId) {
        this.operationUserId = operationUserId;
    }

    public String getBeforeContent() {
        return beforeContent;
    }

    public void setBeforeContent(String beforeContent) {
        this.beforeContent = beforeContent == null ? null : beforeContent.trim();
    }

    public String getAfterContent() {
        return afterContent;
    }

    public void setAfterContent(String afterContent) {
        this.afterContent = afterContent == null ? null : afterContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", operationUserId=").append(operationUserId);
        sb.append(", beforeContent=").append(beforeContent);
        sb.append(", afterContent=").append(afterContent);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}