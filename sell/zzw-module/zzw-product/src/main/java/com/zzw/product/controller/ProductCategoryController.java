package com.zzw.product.controller;


import com.zzw.common.core.rest.controller.AbstractController;
import com.zzw.core.api.po.product.ProductCategory;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhang
 * @since 2019-09-29
 */
@Controller
@RequestMapping("/productCategory")
@Api(value = "productCategory", tags = "产品类目功能", description = "产品类目管理接口")
public class ProductCategoryController extends AbstractController<ProductCategory, Integer> {

}

