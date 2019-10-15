package com.zzw.core.api.feign;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zzw.common.core.constant.ServiceNameConstants;
import com.zzw.core.api.dto.product.CartDTO;
import com.zzw.core.api.feign.factory.ProductFeignFallbackFactory;
import com.zzw.core.api.po.product.ProductInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhangzhiwen
 */
@FeignClient(name = ServiceNameConstants.PRODUCT_SERVICE,fallbackFactory= ProductFeignFallbackFactory.class)
public interface ProductFeign {
    /**
     * @return  String
     */
    @GetMapping("/msg")
    String msg();

    /**
     * 根据IdList查找商品详细信息
     * @param idList
     * @return
     */
    @GetMapping(value = "/productInfo/listByIdList")
    List<ProductInfo> listByIdList(@RequestParam("idList") List<String> idList);

    @PutMapping(value = "/productInfo/decreaseStock")
    Integer decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
