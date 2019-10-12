/**
 * @filename:OrderMasterService 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.form.order.OrderForm;
import com.zzw.core.api.po.order.OrderMaster;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单信息服务层</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
public interface OrderMasterService extends IService<OrderMaster> {
    OrderDTO create(OrderDTO orderDTO);
}