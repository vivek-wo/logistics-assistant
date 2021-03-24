package com.lanfang.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lanfang.logistics.configuration.PropertiesConfiguration;
import com.lanfang.logistics.entity.Company;
import com.lanfang.logistics.entity.Site;
import com.lanfang.logistics.entity.User;
import com.lanfang.logistics.form.SiteForm;
import com.lanfang.logistics.service.ICompanyService;
import com.lanfang.logistics.service.ISiteService;
import com.lanfang.logistics.util.UploadFileUtils;
import com.lanfang.logistics.vo.CompanySiteVo;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
@Api("网点管理")
@RestController
@RequestMapping("/api")
public class SiteController {

    private ICompanyService companyService;
    public ISiteService siteService;

    @Autowired
    public SiteController(ICompanyService companyService, ISiteService siteService) {
        this.companyService = companyService;
        this.siteService = siteService;
    }

    private PropertiesConfiguration propertiesConfiguration;

    @Autowired
    public void setPropertiesConfiguration(PropertiesConfiguration propertiesConfiguration) {
        this.propertiesConfiguration = propertiesConfiguration;
    }

    @ApiOperation("创建公司网点")
    @PostMapping("/v0/logistics/createCompanySite")
    public ResultVo<String> createCompanySite(@Validated SiteForm siteForm, HttpServletRequest request) {
        Company company = this.companyService.getById(siteForm.getCompanyId());
        if (company == null) {
            return ResultVo.errorWidthService("公司不存在");
        }
        Site site = new Site();
        BeanUtils.copyProperties(siteForm, site);
        if (siteForm.getPhotoFile() != null) {
            //TODO 替换本地路径
            String basePath = request.getServletContext().getRealPath(propertiesConfiguration.getUploadFilePath());
            try {
                String path = UploadFileUtils.saveImageFile(basePath, siteForm.getPhotoFile());
                site.setSitePhotoPath(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.siteService.save(site);
        return ResultVo.successOnlyMessage("创建成功");
    }

    @ApiOperation("获取公司网点信息")
    @GetMapping("/v0/logistics/getCompanySite")
    public ResultVo<List<CompanySiteVo>> getCompanySite(long companyId) {
        QueryWrapper<Site> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("companyId", companyId);
        List<Site> siteList = this.siteService.list(queryWrapper);
        List<CompanySiteVo> resultList = new ArrayList<>();
        if (siteList != null && !siteList.isEmpty()) {
            for (Site site : siteList) {
                CompanySiteVo companySiteVo = new CompanySiteVo();
                BeanUtils.copyProperties(site, companySiteVo);
                resultList.add(companySiteVo);
            }
        }
        return ResultVo.successWidthBody(resultList);
    }

}
