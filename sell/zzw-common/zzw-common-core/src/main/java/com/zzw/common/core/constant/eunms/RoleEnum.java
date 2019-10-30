package com.zzw.common.core.constant.eunms;

import lombok.Getter;

/**
 * 角色枚举
 * @author zhangzhiwen
 */
@Getter
public enum RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"买家"),
    ;
    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
