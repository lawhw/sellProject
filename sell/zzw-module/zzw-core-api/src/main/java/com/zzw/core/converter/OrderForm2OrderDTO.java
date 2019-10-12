package com.zzw.core.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zzw.common.core.constant.eunms.ResultEnum;
import com.zzw.common.core.exception.OrderException;
import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.form.order.OrderForm;
import com.zzw.core.api.po.order.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO= new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Gson gson = new Gson();
        try {

            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken< List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("[json转换]错误，String={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
