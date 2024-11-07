package com.dkd.manage.domain.dto;


public class TaskDetailsDto {

    private String channelCode;// 货道编号
    private Long expectCapacity;// 期望补货数量
    private Long skuId;// 商品Id
    private String skuName;// 商品名称
    private String skuImage;// 商品图片

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Long getExpectCapacity() {
        return expectCapacity;
    }

    public void setExpectCapacity(Long expectCapacity) {
        this.expectCapacity = expectCapacity;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuImage() {
        return skuImage;
    }

    public void setSkuImage(String skuImage) {
        this.skuImage = skuImage;
    }
}