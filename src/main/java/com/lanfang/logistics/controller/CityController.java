package com.lanfang.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lanfang.logistics.entity.City;
import com.lanfang.logistics.service.ICityService;
import com.lanfang.logistics.vo.CityVo;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    private final ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @ApiOperation("获取省份")
    @GetMapping("/v0/city/getProvinceList")
    public ResultVo<List<CityVo>> getProvinceList() {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("province,COUNT(*) AS count");
        queryWrapper.groupBy("province");
        List<City> cityList = this.cityService.list(queryWrapper);
        List<CityVo> resultList = new ArrayList<>();
        if (cityList != null && !cityList.isEmpty()) {
            for (City city : cityList) {
                CityVo cityVo = new CityVo();
                BeanUtils.copyProperties(city, cityVo);
                resultList.add(cityVo);
            }
        }
        return ResultVo.successWidthBody(resultList);
    }

    @ApiOperation("获取省份")
    @GetMapping("/v0/city/getCityByProvince")
    public ResultVo<List<CityVo>> getCityByProvince(String province) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("city,COUNT(*) AS count");
        if (province != null) {
            queryWrapper.eq("province", province);
        }
        queryWrapper.isNotNull("city");
        queryWrapper.groupBy("city");
        List<City> cityList = this.cityService.list(queryWrapper);
        List<CityVo> resultList = new ArrayList<>();
        if (cityList != null && !cityList.isEmpty()) {
            for (City city : cityList) {
                CityVo cityVo = new CityVo();
                BeanUtils.copyProperties(city, cityVo);
                resultList.add(cityVo);
            }
        }
        return ResultVo.successWidthBody(resultList);
    }

    @ApiOperation("获取区")
    @GetMapping("/v0/city/getDistrict")
    public ResultVo<List<CityVo>> getDistrict(String province, String city) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        if (province != null) {
            queryWrapper.eq("province", province);
        }
        if (city != null) {
            queryWrapper.eq("city", city);
        }
        queryWrapper.isNotNull("district");
        List<City> cityList = this.cityService.list(queryWrapper);
        List<CityVo> resultList = new ArrayList<>();
        if (cityList != null && !cityList.isEmpty()) {
            for (City c : cityList) {
                CityVo cityVo = new CityVo();
                BeanUtils.copyProperties(c, cityVo);
                resultList.add(cityVo);
            }
        }
        return ResultVo.successWidthBody(resultList);
    }


}
