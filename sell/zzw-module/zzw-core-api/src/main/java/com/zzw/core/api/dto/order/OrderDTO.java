package com.zzw.core.api.dto.order;

import com.zzw.core.api.po.order.OrderDetail;
import com.zzw.core.api.po.order.OrderMaster;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class OrderDTO extends OrderMaster {
    @ApiModelProperty(name = "orderDetailList" , value = "商品详情信息")
    private List<OrderDetail> orderDetailList;
}
