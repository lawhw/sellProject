package com.zzw.product.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zzw.common.core.rest.controller.AbstractController;
import com.zzw.common.core.rest.baseVO.R;
import com.zzw.core.api.dto.product.CartDTO;
import com.zzw.core.api.po.product.ProductInfo;
import com.zzw.core.api.vo.product.ProductVO;
import com.zzw.product.service.IProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @Override
    @ApiOperation(value = "查询所有" ,  notes="查询所有")
    @GetMapping(value = "")
    public R<List<ProductVO>> list(ProductInfo e) throws Exception{
        return new R(productInfoService.voList());
    }


    @ApiOperation(value = "获取商品列表" ,  notes="根据Id获取商品列表，供fegin调用")
    @PostMapping(value = "listByIdList")
    public List<ProductInfo> listByIdList(@RequestBody List<String> idList) throws Exception{
        return productInfoService.list(Wrappers.<ProductInfo>lambdaQuery().in(ProductInfo::getProductId,idList));
    }

    @ApiOperation(value = "减库存" ,  notes="减库存，供fegin调用")
    @PutMapping(value = "decreaseStock")
    public int decreaseStock(@RequestBody List<CartDTO> cartDTOList) throws Exception{
        return productInfoService.decreaseStock(cartDTOList);
    }

}

