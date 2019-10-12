package com.zzw.common.core.constant.eunms;

import lombok.Getter;

/**
 * 商品相关枚举类
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;
    Integer code;
    String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
