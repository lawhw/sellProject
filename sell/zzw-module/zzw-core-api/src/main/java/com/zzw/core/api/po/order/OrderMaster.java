/**
 * @filename:OrderMaster 2019年10月08日
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
 * <p>说明： 订单信息实体类</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderMaster extends Model<OrderMaster> {

	private static final long serialVersionUID = 1570532989006L;
	
	@TableId
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

	@TableLogic
	@ApiModelProperty(name = "isDelete" , value = "删除标志0-正常，1-删除")
	private Integer isDelete;
    

	@Override
    protected Serializable pkVal() {
        return this.orderId;
    }
}
