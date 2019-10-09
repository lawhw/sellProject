package com.zzw.product.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.core.api.po.product.ProductInfo;
import com.zzw.core.api.vo.product.ProductInfoVO;
import com.zzw.core.api.vo.product.ProductVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhang
 * @since 2019-09-26
 */
public interface IProductInfoService extends IService<ProductInfo> {

    List<ProductVO> voList();
}
