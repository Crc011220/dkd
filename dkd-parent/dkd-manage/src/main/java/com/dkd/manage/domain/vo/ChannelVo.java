package com.dkd.manage.domain.vo;

import com.dkd.manage.domain.Channel;
import com.dkd.manage.domain.TbSku;

public class ChannelVo extends Channel {
    private TbSku sku;
    public TbSku getSku() {
        return sku;
    }
    public void setSku(TbSku sku) {
        this.sku = sku;
    }
}
