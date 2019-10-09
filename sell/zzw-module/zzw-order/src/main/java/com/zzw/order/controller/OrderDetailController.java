/**
 * @filename:OrderDetailController 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.controller;
import com.zzw.core.api.po.order.OrderDetail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zzw.common.core.rest.controller.AbstractController;

import io.swagger.annotations.Api;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单详情API接口层</P>
 * @version: V1.0
 * @author: zzw
 * @time    2019年10月08日
 *
 */
@Api(tags = "订单详情",description = "订单详情",value="订单详情" )
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController extends AbstractController<OrderDetail,String>{

}