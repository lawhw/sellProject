package com.zzw.core.api.dto.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangzhiwen
 */
@Data
public class CartDTO {
    @ApiModelProperty(value = "商品Id")
    private String productId;
    @ApiModelProperty(value = "商品数量")
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
