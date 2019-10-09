package com.zzw.core.api.po.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhang
 * @since 2019-09-29
 */
@Data
@TableName("product_category")
@ApiModel
public class ProductCategory extends Model<ProductCategory> {

    @TableId(value = "category_id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer categoryId;

    @ApiModelProperty(value = "类目名字")
    private String categoryName;

    @ApiModelProperty(value = "类目编号")
    private Integer categoryType;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @TableLogic
    @ApiModelProperty(value = "删除标志0-正常，1-删除")
    private Integer isDelete;

}
