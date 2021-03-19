package com.lanfang.logistics.controller;


import com.lanfang.logistics.entity.Company;
import com.lanfang.logistics.form.CompanyForm;
import com.lanfang.logistics.vo.CompanyVo;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ClassUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
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
    public ResultVo<Long> createCompany(CompanyForm companyForm, HttpServletRequest request) {
//        String path = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        if (companyForm.getLicenseFile() != null || companyForm.getDoorImageFile() != null
                || companyForm.getRoadTransportFile() != null) {
            String basePath = request.getServletContext().getRealPath("static/images/");
            System.out.println("------------basePath: " + basePath);
            File directory = new File(basePath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            if (companyForm.getLicenseFile() != null) {
                String fileName = companyForm.getLicenseFile().getOriginalFilename();
                System.out.println("------------fileName: " + fileName);
                File licenseFile = new File(basePath + "123456789");
                try {
                    companyForm.getLicenseFile().transferTo(licenseFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @ApiOperation("获取公司信息")
    @GetMapping("/v0/logistics/getCompanyInfo")
    public ResultVo<CompanyVo> getCompanyInfo(long companyId) {
        return null;
    }
}
