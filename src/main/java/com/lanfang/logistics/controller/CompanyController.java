package com.lanfang.logistics.controller;


import com.lanfang.logistics.form.CompanyForm;
import com.lanfang.logistics.vo.CompanyVo;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api("公司管理")
@RestController
@RequestMapping("/api")
public class CompanyController {

    @ApiOperation("创建公司")
    @PostMapping("/v0/logistics/createCompany")
    public ResultVo<Long> createCompany(CompanyForm companyForm) {
        return null;
    }

    @ApiOperation("获取公司信息")
    @GetMapping("/v0/logistics/getCompanyInfo")
    public ResultVo<CompanyVo> getCompanyInfo(long companyId) {
        return null;
    }
}
