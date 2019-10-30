package com.zzw.user.service;

import com.zzw.core.api.po.user.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单信息服务层</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getOneByOpenid(String openid);
}