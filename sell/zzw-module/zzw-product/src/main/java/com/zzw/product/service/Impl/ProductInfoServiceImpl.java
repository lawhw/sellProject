package com.zzw.product.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.common.core.constant.eunms.ResultEnum;
import com.zzw.common.core.exception.ProductException;
import com.zzw.core.api.dto.product.CartDTO;
import com.zzw.core.api.po.product.ProductCategory;
import com.zzw.core.api.po.product.ProductInfo;
import com.zzw.core.api.vo.product.ProductInfoVO;
import com.zzw.core.api.vo.product.ProductVO;
import com.zzw.product.mapper.ProductCategoryMapper;
import com.zzw.product.mapper.ProductInfoMapper;
import com.zzw.product.service.IProductInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhang
 * @since 2019-09-26
 */
@Service
@AllArgsConstructor
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {
    private ProductCategoryMapper productCategoryMapper;
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductVO> voList() {
        //1.查询所有在架商品
        List<ProductInfo> productInfoList = baseMapper.selectList(Wrappers.<ProductInfo>emptyWrapper());

        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoList
                .stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3.从数据库查找类目
        List<ProductCategory> categoryList = productCategoryMapper.selectList(
                Wrappers.<ProductCategory>query().lambda()
                .in(ProductCategory::getCategoryType,categoryTypeList)
                );

        //4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        categoryList.forEach(productCategory -> {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(productCategory,productVO);

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            productInfoList.forEach(productInfo -> {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            });
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        });
        return productVOList;
    }

    @Override
    public int decreaseStock(List<CartDTO> cartDTOList) {
        AtomicInteger count = new AtomicInteger();
        cartDTOList.forEach(cartDTO -> {
           ProductInfo productInfo = productInfoMapper.selectById(cartDTO.getProductId());
           //判断商品是否存在
           if(ObjectUtils.isEmpty(productInfo)){
               throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
           }
           //判断库存信息
           Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
           if(result < 0){
               throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
           }
           productInfo.setProductStock(result);
           count.addAndGet(productInfoMapper.updateById(productInfo));
        });
        return count.get();
    }

}
