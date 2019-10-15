package com.zzw.common.core.exception;

import com.zzw.common.core.constant.eunms.ResultEnum;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/14 17:03
 * @description：商品异常类
 * @modified By：
 */
public class ProductException extends RuntimeException{
    private Integer code;
    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
