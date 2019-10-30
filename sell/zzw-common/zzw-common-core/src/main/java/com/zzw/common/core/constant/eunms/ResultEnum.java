package com.zzw.common.core.constant.eunms;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
    PRODUCT_NOT_EXIST(3,"商品不存在"),
    PRODUCT_STOCK_ERROR(4,"库存有误"),
    LOGIN_FAIL(5,"登陆失败"),
    ROLE_ERROR(5,"角色有误"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
