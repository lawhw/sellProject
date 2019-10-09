package com.zzw.order.service;

import com.zzw.common.constant.eunms.OrderStatusEnum;
import com.zzw.common.constant.eunms.PayStatusEnum;
import com.zzw.core.api.po.order.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterServiceTest {

    @Autowired
    private OrderMasterService orderMasterService;

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("121212");
        orderMaster.setBuyerAddress("1323");
        orderMaster.setBuyerName("文");
        orderMaster.setBuyerPhone("15797683468");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        Assert.assertTrue(orderMasterService.save(orderMaster));
    }
}