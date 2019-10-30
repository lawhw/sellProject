package com.zzw.user.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zzw.common.core.constant.CommonConstants;
import com.zzw.common.core.constant.eunms.ResultEnum;
import com.zzw.common.core.constant.eunms.RoleEnum;
import com.zzw.common.core.rest.baseVO.R;
import com.zzw.common.core.util.CookieUtil;
import com.zzw.core.api.po.user.UserInfo;
import com.zzw.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhangzhiwen
 * @date ：Created in 2019/10/29 20:45
 * @description：登陆相关
 * @modified By：
 */
@Api(tags = "登陆", description = "登陆相关接口", value = "用户信息")
@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    private UserInfoService userInfoService;
    private StringRedisTemplate redisTemplate;

    @ApiOperation(value = "买家根据openid登陆", notes = "根据openid登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openid", value = "openid", required = true)
    })
    @ResponseBody
    @GetMapping(value = "/buyer")
    public R buyer(@RequestParam("openid") String openid, HttpServletResponse response) throws Exception {
        //1.openid和数据库数据相比较
        UserInfo userInfo = userInfoService.getOneByOpenid(openid);
        if (ObjectUtils.isEmpty(userInfo)) {
            return R.fail(ResultEnum.LOGIN_FAIL.getMessage());
        }
        //2.判断角色
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            return R.fail(ResultEnum.ROLE_ERROR.getMessage());
        }

        //3.设置cookie openid=abc
        CookieUtil.set(response, CommonConstants.OPENID, openid, CommonConstants.expire);
        return new R();

    }

    @ApiOperation(value = "卖家根据openid登陆", notes = "根据openid登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openid", value = "openid", required = true)
    })
    @ResponseBody
    @GetMapping(value = "/seller")
    public R seller(@RequestParam("openid") String openid, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //判断是否登录
        Cookie cookie = CookieUtil.get(request, CommonConstants.TOKEN);
        String requestToken = redisTemplate.opsForValue().get(
                String.format(CommonConstants.TOKEN_TEMPLATE, cookie.getValue())
        );
        if (ObjectUtils.isNotEmpty(cookie) &&
                StringUtils.isNotEmpty(requestToken)) {
            return new R();
        }

        //1.openid和数据库数据相比较
        UserInfo userInfo = userInfoService.getOneByOpenid(openid);
        if (ObjectUtils.isEmpty(userInfo)) {
            return R.fail(ResultEnum.LOGIN_FAIL.getMessage());
        }
        //2.判断角色
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            return R.fail(ResultEnum.ROLE_ERROR.getMessage());
        }

        //3.redis设置key=token_uuid, value=openid
        String token = UUID.randomUUID().toString();
        Integer expire = CommonConstants.expire;
        redisTemplate.opsForValue().set(
                String.format(CommonConstants.TOKEN_TEMPLATE, token),
                openid,
                expire,
                TimeUnit.SECONDS
        );
        //4.设置cookie token=uuid
        CookieUtil.set(response, CommonConstants.TOKEN, token, CommonConstants.expire);
        return new R();
    }

}
