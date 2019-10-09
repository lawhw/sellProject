/**
 * @filename:OrderMaster 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.core.api.vo.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.zzw.core.api.po.order.OrderDetail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单信息实体类</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Data
public class OrderVO{

	private static final long serialVersionUID = 1570532989006L;
	
	@ApiModelProperty(name = "orderId" , value = "")
	private String orderId;
    
	@ApiModelProperty(name = "buyerName" , value = "买家名字")
	private String buyerName;
    
	@ApiModelProperty(name = "buyerPhone" , value = "买家电话")
	private String buyerPhone;
    
	@ApiModelProperty(name = "buyerAddress" , value = "买家地址")
	private String buyerAddress;
    
	@ApiModelProperty(name = "buyerOpenid" , value = "买家微信openid")
	private String buyerOpenid;
    
	@ApiModelProperty(name = "orderAmount" , value = "订单总金额")
	private BigDecimal orderAmount;
    
	@ApiModelProperty(name = "orderStatus" , value = "订单状态, 默认为新下单")
	private Integer orderStatus;
    
	@ApiModelProperty(name = "payStatus" , value = "支付状态, 默认未支付")
	private Integer payStatus;
    
	@ApiModelProperty(name = "createTime" , value = "创建时间")
	private LocalDateTime createTime;
    
	@ApiModelProperty(name = "updateTime" , value = "修改时间")
	private LocalDateTime updateTime;

	@ApiModelProperty(name = "orderDetailList" , value = "商品详情信息")
	private List<OrderDetail> orderDetailList;
}
