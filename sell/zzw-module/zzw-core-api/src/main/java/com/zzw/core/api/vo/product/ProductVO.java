package com.zzw.core.api.vo.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zzw.core.api.po.product.ProductInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    @ApiModelProperty(value = "类目编号")
    @JsonProperty("name")
    private String categoryName;

    @ApiModelProperty(value = "类目编号")
    @JsonProperty("type")
    private Integer categoryType;

    @ApiModelProperty(value = "类目编号")
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
