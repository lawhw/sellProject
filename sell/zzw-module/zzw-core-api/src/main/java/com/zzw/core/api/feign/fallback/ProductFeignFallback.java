package com.zzw.core.api.feign.fallback;

import com.zzw.core.api.dto.product.CartDTO;
import com.zzw.core.api.feign.ProductFeign;
import com.zzw.core.api.po.product.ProductInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangzhiwen
 */
@Slf4j
@Data
@Component
public class ProductFeignFallback implements ProductFeign {
    private Throwable cause;

    @Override
    public String msg() {
        log.error("feign 查询失败", cause);
        return null;
    }

    @Override
    public List<ProductInfo> listByIdList(List<String> idList) {
        log.error("feign 根据idList查询详细信息失败 param={}",idList, cause);
        return null;
    }

    @Override
    public Integer decreaseStock(List<CartDTO> cartDTOList) {
        log.error("feign 扣减库存失败 param={}",cartDTOList, cause);
        return null;
    }
}
