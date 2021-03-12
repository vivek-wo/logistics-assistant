package com.lanfang.logistics.controller;

import com.lanfang.logistics.vo.ResultVo;
import com.lanfang.logistics.vo.WXAuthVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/api")
public class WXAuthController {

    @PostMapping("/v0/wx/wxLogin")
    public ResultVo<WXAuthVo> wxLogin(@Validated @NotEmpty String code) {
        //获取openId session_key
        WXAuthVo wxAuthVo = new WXAuthVo();
        wxAuthVo.setToken("123456789");
        wxAuthVo.setNickName("成功YES");
        //获取用户信息
        return ResultVo.success(wxAuthVo);
    }

}
