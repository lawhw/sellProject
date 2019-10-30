package com.zzw.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zzw.core.api.po.user.UserInfo;
import com.zzw.user.mapper.UserInfoMapper;
import com.zzw.user.service.UserInfoService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 订单信息服务实现层</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Service
public class UserInfoServiceImpl  extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService  {

    @Override
    public UserInfo getOneByOpenid(String openid) {
        return baseMapper.selectOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getOpenid,openid));
    }
}