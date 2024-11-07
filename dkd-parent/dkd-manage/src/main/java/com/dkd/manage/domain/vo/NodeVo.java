package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Node;
import com.dkd.manage.domain.Partner;
import com.dkd.manage.domain.Region;

public class NodeVo extends Node {
    //设备数量
    private Integer vmCount;

    //区域信息
    private Region region;

    //合作商信息
    private Partner partner;


    public Integer getVmCount() {
        return vmCount;
    }

    public void setVmCount(Integer vmCount) {
        this.vmCount = vmCount;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
