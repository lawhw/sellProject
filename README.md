时间：2019年10月09日

**sell**

以Spring cloud+mybatis-plus+swagger+mysql+lomback+代码生成器（聚合工程）

**zw-common**

一些公共的配置.工具类.jar包.....都可以放进去，已有部分公用类。

**zzw-eureka**

springcloud服务中心

**zzw-module**

业务模块，可以根据业务需求添加服务聚合到该模块中，现已有部分模块可以供参考

**zzw-visual**

一些视图化服务，现已经加入代码生成器，期待加入其他服务。


*代码业务逻辑借鉴廖师兄微信点餐系统，项目待完善*

*完美集成lombok，swagger的代码生成工具，让你不再为繁琐的注释和简单的接口实现而烦恼：entity集成，格式校验，swagger; dao自动加@ mapper，service自动注释和依赖; 控制器实现单表的增副改查*

####各版本信息
```
    <properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Finchley.SR3</spring-cloud.version>
        <spring-boot.version>2.0.8.RELEASE</spring-boot.version>
        <mysql.version>8.0.11</mysql.version>
        <mybatis-plus.version>3.1.0</mybatis-plus.version>
        <velocity.version>1.7</velocity.version>
        <springfox-swagger2>2.9.2</springfox-swagger2>
        <old-springfox-swagger2>1.5.21</old-springfox-swagger2>
        <swagger-bootstrap>1.9.6</swagger-bootstrap>
        <freemarker.version>2.3.28</freemarker.version>
    </properties>
```
```
        <!--mybatisplus相关-->
		<!--mybatis plus extension,包含了mybatis plus core-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-extension</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>
		<!--代码生成模板引擎-->
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>${freemarker.version}</version>
        </dependency>
	    <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!--swagger相关-->
        <!-- spring boot整合swagger2 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${springfox-swagger2}</version>
            <scope>compile</scope>
            <!--
            排除2.9.2版本原有的子类，下方重新单独引用1.5.21版本的子类
            如此操作的原因是为了解决2.9.2版本在访问初始UI时会出现java.lang.NumberFormatException: For input string: ""错误
            -->
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${springfox-swagger2}</version>
        </dependency>
        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-annotations</artifactId>
            <version>${old-springfox-swagger2}</version>
        </dependency>
        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
            <version>${old-springfox-swagger2}</version>
        </dependency>
		
		<!--其他相应jar包-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
####数据库设计
```
-- 类目
create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment '类目名字',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
		`is_delete` tinyint(3) not null default 0 comment '删除标志0-正常，1-删除',
    primary key (`category_id`),
    unique key `uqe_category_type` (`category_type`)
);
INSERT INTO `product_category` (`category_id`, `category_name`, `category_type`, `create_time`, `update_time`)
VALUES
	(1,'热榜',11,'2017-03-28 16:40:22','2017-11-26 23:39:36'),
	(2,'好吃的',22,'2017-03-14 17:38:46','2017-11-26 23:39:40');

-- 商品
create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '单价',
    `product_stock` int not null comment '库存',
    `product_description` varchar(64) comment '描述',
    `product_icon` varchar(512) comment '小图',
    `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
		`is_delete` tinyint(3) not null default 0 comment '删除标志0-正常，1-删除',
    primary key (`product_id`)
);
INSERT INTO `product_info` (`product_id`, `product_name`, `product_price`, `product_stock`, `product_description`, `product_icon`, `product_status`, `category_type`, `create_time`, `update_time`)
VALUES
	('157875196366160022','皮蛋粥',0.01,39,'好吃的皮蛋粥','//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg',0,1,'2017-03-28 19:39:15','2017-07-02 11:45:44'),
	('157875227953464068','慕斯蛋糕',10.90,200,'美味爽口','//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg',1,1,'2017-03-28 19:35:54','2017-04-21 10:05:57'),
	('164103465734242707','蜜汁鸡翅',0.02,982,'好吃','//fuss10.elemecdn.com/7/4a/f307f56216b03f067155aec8b124ejpeg.jpeg',0,1,'2017-03-30 17:11:56','2017-06-24 19:20:54');





-- 订单
create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment '买家名字',
    `buyer_phone` varchar(32) not null comment '买家电话',
    `buyer_address` varchar(128) not null comment '买家地址',
    `buyer_openid` varchar(64) not null comment '买家微信openid',
    `order_amount` decimal(8,2) not null comment '订单总金额',
    `order_status` tinyint(3) not null default '0' comment '订单状态, 默认为新下单',
    `pay_status` tinyint(3) not null default '0' comment '支付状态, 默认未支付',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
		`is_delete` tinyint(3) not null default 0 comment '删除标志0-正常，1-删除',
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
);

-- 订单商品
create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '当前价格,单位分',
    `product_quantity` int not null comment '数量',
    `product_icon` varchar(512) comment '小图',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
		`is_delete` tinyint(3) not null default 0 comment '删除标志0-正常，1-删除',
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
);
```
*要求必须有主键为id便于mybatisplus生成主键注解,数据库字段和表名有注释swagger才会生成注释*


####mybatis-plus的配置
```
package com.zzw.order.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuyf
 * @date 2019/3/18
 */
@Configuration
@MapperScan("com.zzw.order.mapper")
public class MybatisPlusConfigurer {
	/**
	 * 分页插件
	 *
	 * @return PaginationInterceptor
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}


	/**
	 * 逻辑删除
	 *
	 * @return
	 */
	@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}
}
```

####生成的实体类以（order_detail表为例）
```
/**
 * @filename:OrderDetail 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.core.api.po.order;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单详情实体类</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetail extends Model<OrderDetail> {

	private static final long serialVersionUID = 1570526659292L;
	
	@TableId
	@ApiModelProperty(name = "detailId" , value = "")
	private String detailId;
    
	@ApiModelProperty(name = "orderId" , value = "")
	private String orderId;
    
	@ApiModelProperty(name = "productId" , value = "")
	private String productId;
    
	@ApiModelProperty(name = "productName" , value = "商品名称")
	private String productName;
    
	@ApiModelProperty(name = "productPrice" , value = "当前价格,单位分")
	private BigDecimal productPrice;
    
	@ApiModelProperty(name = "productQuantity" , value = "数量")
	private Integer productQuantity;
    
	@ApiModelProperty(name = "productIcon" , value = "小图")
	private String productIcon;
    
	@ApiModelProperty(name = "createTime" , value = "创建时间")
	private LocalDateTime createTime;
    
	@ApiModelProperty(name = "updateTime" , value = "修改时间")
	private LocalDateTime updateTime;

	@TableLogic
	@ApiModelProperty(name = "isDelete" , value = "删除标志0-正常，1-删除")
	private Integer isDelete;
    

	@Override
    protected Serializable pkVal() {
        return this.detailId;
    }
}

```

####生成的Mapper
```
/**
 * @filename:OrderDetailDao 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzw.core.api.po.order.OrderDetail;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单详情数据访问层</p>
 * @version: V1.0
 * @author: zzw
 * 
 */
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
	
}
```
####生成的XML
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zzw.order.mapper.OrderDetailMapper">

	<resultMap id="BaseResultMap" type="com.zzw.core.api.po.order.OrderDetail">
		<id column="detail_id" property="detailId" />
		<result column="order_id" property="orderId" />
		<result column="product_id" property="productId" />
		<result column="product_name" property="productName" />
		<result column="product_price" property="productPrice" />
		<result column="product_quantity" property="productQuantity" />
		<result column="product_icon" property="productIcon" />
		<result column="create_time" property="createTime" />
		<result column="update_time" property="updateTime" />
		<result column="is_delete" property="isDelete" />
	</resultMap>
	<sql id="Base_Column_List">
		detail_id, order_id, product_id, product_name, product_price, product_quantity, product_icon, create_time, update_time, is_delete
	</sql>
	
</mapper>
```
####生成的SERVICE

```
/**
 * @filename:OrderDetailService 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.core.api.po.order.OrderDetail;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单详情服务层</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
public interface OrderDetailService extends IService<OrderDetail> {
	
}
```
```
/**
 * @filename:OrderDetailServiceImpl 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2018 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.service.impl;

import com.zzw.core.api.po.order.OrderDetail;
import com.zzw.order.mapper.OrderDetailMapper;
import com.zzw.order.service.OrderDetailService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 订单详情服务实现层</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Service
public class OrderDetailServiceImpl  extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService  {
	
}
```

####生成的CONTROLLER，父类有一些常用的增删查改等供能
```
/**
 * @filename:OrderDetailController 2019年10月08日
 * @project sell  V1.0
 * Copyright(c) 2020 zzw Co. Ltd. 
 * All right reserved. 
 */
package com.zzw.order.controller;
import com.zzw.core.api.po.order.OrderDetail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zzw.common.core.rest.controller.AbstractController;

import io.swagger.annotations.Api;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单详情API接口层</P>
 * @version: V1.0
 * @author: zzw
 * @time    2019年10月08日
 *
 */
@Api(tags = "订单详情",description = "订单详情",value="订单详情" )
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController extends AbstractController<OrderDetail,String>{

}
```
