package com.zzw.core.api.vo.product;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhang
 * @since 2019-09-26
 */
@Data
@ApiModel
public class ProductInfoVO {

    @ApiModelProperty(value = "商品编码")
    @JsonProperty("id")
    private String productId;

    @ApiModelProperty(value = "商品名称")
    @JsonProperty("name")
    private String productName;

    @ApiModelProperty(value = "单价")
    @JsonProperty("price")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "描述")
    @JsonProperty("description")
    private String productDescription;

    @ApiModelProperty(value = "小图")
    @JsonProperty("icon")
    private String productIcon;

}
