package com.lanfang.logistics.controller;


import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Api("发车管理")
@RestController
@RequestMapping("/api")
public class DepartureController {

    @ApiOperation("新增发车")
    @PostMapping("/v0/logistics/createDepartureTime")
    public ResultVo<String> createDepartureTime(long startSite, String middleSites, long endSite) {
        return null;
    }

}
