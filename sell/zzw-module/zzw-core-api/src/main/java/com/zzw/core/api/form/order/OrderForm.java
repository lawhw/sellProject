package com.zzw.core.api.form.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class OrderForm {
    @NotNull(message = "姓名必填")
    @ApiModelProperty(name = "name" , value = "买家名字")
    private String name;

    @NotNull(message = "手机号必填")
    @ApiModelProperty(name = "phone" , value = "买家电话")
    private String phone;

    @NotNull(message = "地址必填")
    @ApiModelProperty(name = "address" , value = "买家地址")
    private String address;

    @NotNull(message = "openid必填")
    @ApiModelProperty(name = "openid" , value = "买家微信openid")
    private String openid;

    @NotNull(message = "购物车不能为空")
    @ApiModelProperty(name = "orderDetailList" , value = "购物车")
    private String items;

}
