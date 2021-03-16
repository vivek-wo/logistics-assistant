package com.lanfang.logistics.controller;

import com.lanfang.logistics.form.CompanyForm;
import com.lanfang.logistics.form.DLineForm;
import com.lanfang.logistics.form.SiteForm;
import com.lanfang.logistics.vo.CompanySiteVo;
import com.lanfang.logistics.vo.CompanyVo;
import com.lanfang.logistics.vo.DedicatedLineVo;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("物流管理")
@RestController
@RequestMapping("/api")
public class LogisticsController {

    @ApiOperation("创建公司")
    @PostMapping("/v0/logistics/createCompany")
    public ResultVo<Long> createCompany(CompanyForm companyForm) {
        return null;
    }

    @ApiOperation("创建公司网点")
    @PostMapping("/v0/logistics/createCompanySite")
    public ResultVo<String> createCompanySite(SiteForm siteForm) {
        return null;
    }

    @ApiOperation("创建专线")
    @PostMapping("/v0/logistics/createDedicatedLine")
    public ResultVo<String> createDedicatedLine(DLineForm dLineForm) {
        return null;
    }

    @ApiOperation("新增发车")
    @PostMapping("/v0/logistics/createDepartureTime")
    public ResultVo<String> createDepartureTime(long startSite, String middleSites, long endSite) {
        return null;
    }

    @ApiOperation("获取公司信息")
    @GetMapping("/v0/logistics/getCompantInfo")
    public ResultVo<CompanyVo> getCompanyInfo(long companyId) {
        return null;
    }

    @ApiOperation("获取公司网点信息")
    @GetMapping("/v0/logistics/getCompanySite")
    public ResultVo<List<CompanySiteVo>> getCompanySite(long companyId) {
        return null;
    }

    @ApiOperation("查询专线")
    @GetMapping("/v0/logistics/queryDedicatedLine")
    public ResultVo<List<DedicatedLineVo>> queryDedicatedLine(long companyId, String region) {
        return null;
    }

}
