package com.dkd.manage.domain.dto;

import java.util.List;

// 售货机货道配置
public class ChannelConfigDto {

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public List<ChannelSkuDto> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelSkuDto> channelList) {
        this.channelList = channelList;
    }

    // 售货机编号
    private String innerCode;
    // 货道配置
    private List<ChannelSkuDto> channelList;
}