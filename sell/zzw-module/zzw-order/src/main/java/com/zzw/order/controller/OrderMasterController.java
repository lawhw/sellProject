/**
 * @filename:OrderMasterController 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.controller;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.zzw.common.core.constant.eunms.ResultEnum;
import com.zzw.common.core.exception.OrderException;
import com.zzw.common.core.rest.baseVO.R;
import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.form.order.OrderForm;
import com.zzw.core.api.po.order.OrderMaster;
import com.zzw.core.converter.OrderForm2OrderDTO;
import com.zzw.order.service.OrderMasterService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.zzw.common.core.rest.controller.AbstractController;

import io.swagger.annotations.Api;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单信息API接口层</P>
 * @version: V1.0
 * @author: zzw
 * @time    2019年10月08日
 *
 */
@Slf4j
@Api(tags = "订单信息",description = "订单信息",value="订单信息" )
@RestController
@RequestMapping("/orderMaster")
@AllArgsConstructor
public class OrderMasterController extends AbstractController<OrderMaster,String>{
    private OrderMasterService orderMasterService;
    @ApiOperation(value = "新增并关联对应关系" ,  notes="新增并关联对应关系")
    @ResponseBody
    @PostMapping(value = "/orderDTO")
    public R<Map<String,String>> post(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult) throws Exception {
//        validate(result);
        if(bindingResult.hasErrors()){
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        //orderFrom -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);

        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单]购物车信息为空");
            throw  new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderMasterService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return new R(map);
    }

    @ApiOperation(value = "完结订单" ,  notes="新增并关联对应关系")
    @ResponseBody
    @PutMapping(value = "/finish")
    public R<OrderDTO> finish(@RequestParam("orderId") String orderId) throws Exception {
        return new R(orderMasterService.finish(orderId));
    }

}