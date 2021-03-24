package com.lanfang.logistics.controller;


import com.lanfang.logistics.configuration.PropertiesConfiguration;
import com.lanfang.logistics.entity.Company;
import com.lanfang.logistics.entity.User;
import com.lanfang.logistics.form.CompanyForm;
import com.lanfang.logistics.service.ICompanyService;
import com.lanfang.logistics.service.IUserService;
import com.lanfang.logistics.util.UploadFileUtils;
import com.lanfang.logistics.vo.CompanyVo;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    private PropertiesConfiguration propertiesConfiguration;

    private IUserService userService;
    private ICompanyService companyService;

    @Autowired
    public CompanyController(IUserService userService, ICompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @Autowired
    public void setPropertiesConfiguration(PropertiesConfiguration propertiesConfiguration) {
        this.propertiesConfiguration = propertiesConfiguration;
    }

    @ApiOperation("创建公司")
    @PostMapping("/v0/logistics/createCompany")
    public ResultVo<Long> createCompany(CompanyForm companyForm, HttpServletRequest request) {
        User user = this.userService.getById(companyForm.getLegalUserId());
        if (user == null) {
            return ResultVo.errorWidthService("用户不存在");
        }
        Company company = new Company(companyForm.getName(), companyForm.getRegion(), companyForm.getAddress(),
                companyForm.getLegalUserId());
        if (companyForm.getLicenseFile() != null || companyForm.getDoorImageFile() != null
                || companyForm.getRoadTransportFile() != null) {
            //TODO 替换本地路径
            String basePath = request.getServletContext().getRealPath(propertiesConfiguration.getUploadFilePath());
            String baseIDPath = request.getServletContext().getRealPath(propertiesConfiguration.getUploadIDPhotoPath());
            try {
                if (companyForm.getLicenseFile() != null) {
                    String localPath = UploadFileUtils.saveImageFile(baseIDPath, companyForm.getLicenseFile());
                    company.setLicensePath(localPath);
                }
                if (companyForm.getDoorImageFile() != null) {
                    String localPath = UploadFileUtils.saveImageFile(basePath, companyForm.getDoorImageFile());
                    company.setDoorImagePath(localPath);
                }
                if (companyForm.getRoadTransportFile() != null) {
                    String localPath = UploadFileUtils.saveImageFile(baseIDPath, companyForm.getRoadTransportFile());
                    company.setRoadLicensePath(localPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.companyService.save(company);
        return ResultVo.successOnlyMessage("创建成功");
    }

    @ApiOperation("获取公司信息")
    @GetMapping("/v0/logistics/getCompanyInfo")
    public ResultVo<CompanyVo> getCompanyInfo(long companyId) {
        Company company = this.companyService.getById(companyId);
        if (company == null) {
            return ResultVo.errorWidthService("公司不存在");
        }
        CompanyVo companyVo = new CompanyVo();
        BeanUtils.copyProperties(company, companyVo);
        return ResultVo.successWidthBody(companyVo);
    }
}
