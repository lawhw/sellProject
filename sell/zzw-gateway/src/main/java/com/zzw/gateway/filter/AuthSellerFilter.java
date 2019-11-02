package com.zzw.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zzw.common.core.constant.CommonConstants;
import com.zzw.common.core.util.CookieUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/29 11:00
 * @description：鉴权区分买家端和卖家端
 * @modified By：
 */
@Slf4j
@Component
@AllArgsConstructor
public class AuthSellerFilter extends ZuulFilter {
    private StringRedisTemplate redisTemplate;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if("/zzw-order/orderMaster/finish".equals(request.getRequestURI())){
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        /**
         * /orderMahttp://localhost:9999/zzw-order/orderMaster/orderDTOster/orderDTO 只能买家访问(cookie里面有openid)
         * /orderMaster/finish 只能卖家访问（cookie有token，并且对应的redis中值）
         * /productInfo/listByIdList 所有都可以访问
         */
        Cookie cookie = CookieUtil.get(request,"token");
        if(cookie== null
                || StringUtils.isEmpty(cookie.getValue())
                || StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(CommonConstants.TOKEN_TEMPLATE,cookie.getValue())))){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        return null;
    }
}
