package com.lanfang.logistics.controller;


import com.lanfang.logistics.vo.CityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Api("地区管理")
@RestController
@RequestMapping("/api")
public class CityController {

    @ApiOperation("获取省份")
    @GetMapping("/v0/city/getProvinceList")
    public List<CityVo> getProvinceList() {
        return null;
    }

    @ApiOperation("获取省份")
    @GetMapping("/v0/city/getCityByProvince")
    public List<CityVo> getCityByProvince() {
        return null;
    }


}
