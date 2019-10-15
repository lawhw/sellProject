package com.zzw.product.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.core.api.dto.product.CartDTO;
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
    /**
     * 查询所有的商品详细信息
     * @return List<ProductVO>
     */
    List<ProductVO> voList();

    /**
     * 扣除库存
     * * @return int
     */
    int decreaseStock(List<CartDTO> cartDTOList);

}
