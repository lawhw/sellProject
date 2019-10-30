package com.zzw.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @author zhangzhiwen
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    /**
//     * 配置动态路由
//     * @return
//     */
//    @ConfigurationProperties("zuul")
//    @RefreshScope
//    public ZuulProperties zuulProperties(){
//        return new ZuulProperties();
//    }
}
