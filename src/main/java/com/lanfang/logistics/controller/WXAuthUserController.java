package com.lanfang.logistics.controller;


import com.lanfang.logistics.configuration.PropertiesConfiguration;
import com.lanfang.logistics.entity.WXAuthData;
import com.lanfang.logistics.vo.ResultVo;
import com.lanfang.logistics.vo.WXAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Api("微信授权管理")
@RestController
@RequestMapping("/api")
public class WXAuthUserController {

    private final RestTemplate restTemplate;

    private final PropertiesConfiguration propertiesConfiguration;

    @Autowired
    public WXAuthUserController(RestTemplate restTemplate, PropertiesConfiguration propertiesConfiguration) {
        this.restTemplate = restTemplate;
        this.propertiesConfiguration = propertiesConfiguration;
    }

    @ApiOperation("微信小程序登录")
    @PostMapping("/v0/wx/wxLogin")
    public ResultVo<WXAuthVo> wxLogin(@ApiParam(value = "微信Code", required = true) String code) {
        WXAuthVo wxAuthVo = null;
        Map<String, String> paramMaps = new HashMap<>();
        paramMaps.put("appid", propertiesConfiguration.getWxAppId());
        paramMaps.put("secret", propertiesConfiguration.getWxSecret());
        paramMaps.put("js_code", code);
        paramMaps.put("grant_type", "authorization_code");
        ResponseEntity<WXAuthData> responseEntity = this.restTemplate.getForEntity(propertiesConfiguration.getWxTokenUrl(),
                WXAuthData.class, paramMaps);
        System.out.println("-- : " + responseEntity.toString());
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            WXAuthData data = responseEntity.getBody();
            System.out.println("-- data: " + data.toString());
        }
        return ResultVo.successOnlyMessage("成功");
    }
}
