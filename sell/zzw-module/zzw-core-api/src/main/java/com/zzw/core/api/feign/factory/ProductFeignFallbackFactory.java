package com.zzw.core.api.feign.factory;

import com.zzw.core.api.feign.ProductFeign;
import com.zzw.core.api.feign.fallback.ProductFeignFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhang
 */
@Component
public class ProductFeignFallbackFactory implements FallbackFactory<ProductFeign> {

	@Override
	public ProductFeign create(Throwable throwable) {
		ProductFeignFallback productFeignFallback = new ProductFeignFallback();
		productFeignFallback.setCause(throwable);
		return productFeignFallback;
	}
}
