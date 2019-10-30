package com.zzw.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zzw.common.core.util.JsonUtil;
import com.zzw.core.api.po.product.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/28 8:48
 * @description：
 * @modified By：
 */
@Component
@Slf4j
public class ProductInfoReceiver {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String product_stock_template = "product_stock_%s";
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        //message => ProductInfoOutput
        List<ProductInfo> productInfoList = (List<ProductInfo>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfo>>() {});
        log.info("从队列【{}】接收到消息：{}", "productInfo", productInfoList);
        //储存到redis中
        productInfoList.forEach(productInfo -> {
            redisTemplate.opsForValue().set(String.format(product_stock_template,productInfo.getProductId()),String.valueOf(productInfo.getProductStock()));
        });

    }

}
