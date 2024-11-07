package com.dkd.manage.domain.dto;


import java.util.List;

public class TaskDto {
   
    private Long createType;// 创建类型
    private String innerCode;// 关联设备编号
    private Long userId;// 任务执行人Id
    private Long assignorId;// 用户创建人id
    private Long productTypeId;// 工单类型
    private String desc;// 描述信息
    private List<TaskDetailsDto> details;// 工单详情(只有补货工单才涉及)

    public Long getCreateType() {
        return createType;
    }

    public void setCreateType(Long createType) {
        this.createType = createType;
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAssignorId() {
        return assignorId;
    }

    public void setAssignorId(Long assignorId) {
        this.assignorId = assignorId;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<TaskDetailsDto> getDetails() {
        return details;
    }

    public void setDetails(List<TaskDetailsDto> details) {
        this.details = details;
    }
}