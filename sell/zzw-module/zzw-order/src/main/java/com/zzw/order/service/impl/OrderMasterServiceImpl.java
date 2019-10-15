/**
 * @filename:OrderMasterServiceImpl 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2018 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.service.impl;

import com.zzw.common.core.util.KeyUtil;
import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.dto.product.CartDTO;
import com.zzw.core.api.feign.ProductFeign;
import com.zzw.core.api.po.order.OrderDetail;
import com.zzw.core.api.po.order.OrderMaster;
import com.zzw.core.api.po.product.ProductInfo;
import com.zzw.order.mapper.OrderDetailMapper;
import com.zzw.order.mapper.OrderMasterMapper;
import com.zzw.order.service.OrderMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 订单信息服务实现层</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Service
@AllArgsConstructor
@Transactional
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements OrderMasterService  {
    private ProductFeign productFeign;
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        // 1.查询商品信息
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productFeign.listByIdList(productIdList);
        // 2.计算总价
        AtomicReference<BigDecimal> orderAmount = new AtomicReference<>(new BigDecimal(BigInteger.ZERO));
        orderDTO.getOrderDetailList().forEach(orderDetail -> {
            productInfoList.forEach(productInfo -> {
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    //单价*数量
                    orderAmount.set(productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount.get()));
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailMapper.insert(orderDetail);
                }
            });
        });
        // 3.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productFeign.decreaseStock(cartDTOList);
        // 4.订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount.get());
        baseMapper.insert(orderMaster);
        return orderDTO;
    }
}