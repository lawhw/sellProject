package com.zzw.product.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzw.common.core.rest.controller.AbstractController;
import com.zzw.common.core.util.R;
import com.zzw.core.api.po.product.ProductInfo;
import com.zzw.product.service.IProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhang
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/productInfo")
@Api(value = "productInfo", tags = "产品功能", description = "产品表管理接口")
@AllArgsConstructor
public class ProductInfoController extends AbstractController<ProductInfo, String> {

    private IProductInfoService productInfoService;

    @ApiOperation(value = "查询所有" ,  notes="查询所有")
    @GetMapping(value = "")
    public R list(ProductInfo e) throws Exception{
        return new R(productInfoService.voList());
    }


}

