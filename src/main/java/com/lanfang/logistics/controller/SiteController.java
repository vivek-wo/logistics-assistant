package com.lanfang.logistics.controller;


import com.lanfang.logistics.form.SiteForm;
import com.lanfang.logistics.vo.CompanySiteVo;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Api("网点管理")
@RestController
@RequestMapping("/api")
public class SiteController {

    @ApiOperation("创建公司网点")
    @PostMapping("/v0/logistics/createCompanySite")
    public ResultVo<String> createCompanySite(SiteForm siteForm) {
        return null;
    }

    @ApiOperation("获取公司网点信息")
    @GetMapping("/v0/logistics/getCompanySite")
    public ResultVo<List<CompanySiteVo>> getCompanySite(long companyId) {
        return null;
    }

}
