package com.zzw.core.api.po.product;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

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
@TableName("product_info")
public class ProductInfo extends Model<ProductInfo> {

    @TableId
    @ApiModelProperty(value = "商品编码")//,allowableValues = "1,2,3,4",notes = "1-国家、2-省份、3-城市、4-县区"
    private String productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "单价")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "库存")
    private Integer productStock;

    @ApiModelProperty(value = "描述")
    private String productDescription;

    @ApiModelProperty(value = "小图")
    private String productIcon;

    @ApiModelProperty(value = "商品状态",notes = "0:正常,1:下架")
    private Integer productStatus;

    @ApiModelProperty(value = "类目编号")
    private Integer categoryType;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标志0-正常，1-删除")
    private Integer isDelete;

}
