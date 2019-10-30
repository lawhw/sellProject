package com.zzw.user.controller;
import com.zzw.common.core.rest.baseVO.R;
import com.zzw.core.api.po.user.UserInfo;
import com.zzw.user.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.zzw.common.core.rest.controller.AbstractController;

import io.swagger.annotations.Api;
/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单信息API接口层</P>
 * @version: V1.0
 * @author: zzw
 * @time    2019年10月08日
 *
 */
@Api(tags = "用户信息",description = "用户信息接口",value="用户信息" )
@RestController
@RequestMapping("/userInfo")
@AllArgsConstructor
public class UserInfoController extends AbstractController<UserInfo,String>{
}