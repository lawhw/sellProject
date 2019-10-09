/**
 * @filename:OrderMasterController 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.controller;
import com.zzw.common.core.util.R;
import com.zzw.core.api.dto.order.OrderDTO;
import com.zzw.core.api.po.order.OrderMaster;
import com.zzw.order.service.OrderMasterService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.zzw.common.core.rest.controller.AbstractController;

import io.swagger.annotations.Api;

import javax.validation.Valid;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单信息API接口层</P>
 * @version: V1.0
 * @author: zzw
 * @time    2019年10月08日
 *
 */
@Api(tags = "订单信息",description = "订单信息",value="订单信息" )
@RestController
@RequestMapping("/orderMaster")
@AllArgsConstructor
public class OrderMasterController extends AbstractController<OrderMaster,String>{
    private OrderMasterService orderMasterService;
    @ApiOperation(value = "新增并关联对应关系" ,  notes="新增并关联对应关系")
    @ResponseBody
    @PostMapping(value = "/orderDTO")
    public R post(@Valid @RequestBody OrderDTO e, BindingResult result) throws Exception {
        validate(result);
        return new R<>(orderMasterService.create(e));
    }
}