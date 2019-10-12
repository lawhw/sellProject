/**
 * @filename:OrderMasterServiceImpl 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2018 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.service.impl;

import com.zzw.common.core.util.KeyUtil;
import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.form.order.OrderForm;
import com.zzw.core.api.po.order.OrderMaster;
import com.zzw.order.mapper.OrderDetailMapper;
import com.zzw.order.mapper.OrderMasterMapper;
import com.zzw.order.service.OrderMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements OrderMasterService  {

    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //TODO 1.查询商品信息

        //TODO 2.计算总价

        //TODO 3.扣库存

        //TODO 4.订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        baseMapper.insert(orderMaster);
        return orderDTO;
    }
}