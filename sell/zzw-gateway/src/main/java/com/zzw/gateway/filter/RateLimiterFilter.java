package com.zzw.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.zzw.common.core.exception.RateLimiterException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/29 14:33
 * @description：限流优先级最高
 * @modified By：
 */
@Component
public class RateLimiterFilter extends ZuulFilter {
    /**
     * 一秒添加一个令牌
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 优先级最高
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if(!RATE_LIMITER.tryAcquire()){
           throw new RateLimiterException();
        }
        return null;
    }
}
