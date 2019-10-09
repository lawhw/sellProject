/**
 * @filename:OrderDetail 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.core.api.po.order;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单详情实体类</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetail extends Model<OrderDetail> {

	private static final long serialVersionUID = 1570526659292L;
	
	@TableId
	@ApiModelProperty(name = "detailId" , value = "")
	private String detailId;
    
	@ApiModelProperty(name = "orderId" , value = "")
	private String orderId;
    
	@ApiModelProperty(name = "productId" , value = "")
	private String productId;
    
	@ApiModelProperty(name = "productName" , value = "商品名称")
	private String productName;
    
	@ApiModelProperty(name = "productPrice" , value = "当前价格,单位分")
	private BigDecimal productPrice;
    
	@ApiModelProperty(name = "productQuantity" , value = "数量")
	private Integer productQuantity;
    
	@ApiModelProperty(name = "productIcon" , value = "小图")
	private String productIcon;
    
	@ApiModelProperty(name = "createTime" , value = "创建时间")
	private LocalDateTime createTime;
    
	@ApiModelProperty(name = "updateTime" , value = "修改时间")
	private LocalDateTime updateTime;

	@TableLogic
	@ApiModelProperty(name = "isDelete" , value = "删除标志0-正常，1-删除")
	private Integer isDelete;
    

	@Override
    protected Serializable pkVal() {
        return this.detailId;
    }
}
