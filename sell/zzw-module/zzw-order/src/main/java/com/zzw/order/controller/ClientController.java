package com.zzw.order.controller;

import com.zzw.core.api.feign.ProductFeign;
import com.zzw.core.api.po.product.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangzhiwen
 */
@Slf4j
@RestController
@AllArgsConstructor
public class ClientController {
    private ProductFeign productFeign;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String result = productFeign.msg();
        log.error("结果={}", result);
        return result;
    }

    @GetMapping("/productListByIdList")
    public List<ProductInfo> productListByIdList() {
        List<ProductInfo> result = productFeign.listByIdList(Arrays.asList("157875196366160022", "157875227953464068"));
        log.error("结果={}", result);
        return result;
    }


}
