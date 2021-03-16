package com.lanfang.logistics.controller;

import com.lanfang.logistics.vo.ResultVo;
import com.lanfang.logistics.vo.WXAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("微信授权管理")
@RestController
@RequestMapping("/api")
public class WXAuthController {

    @ApiOperation("微信小程序登录")
    @PostMapping("/v0/wx/wxLogin")
    public ResultVo<WXAuthVo> wxLogin(@ApiParam(value = "微信Code", required = true) String code) {
        //获取openId session_key
        WXAuthVo wxAuthVo = new WXAuthVo();
        wxAuthVo.setToken("123456789");
        wxAuthVo.setNickName("成功YES");
        //获取用户信息
        return ResultVo.success(wxAuthVo);
    }

}
