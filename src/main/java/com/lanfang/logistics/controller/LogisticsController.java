package com.lanfang.logistics.controller;

import com.lanfang.logistics.form.CompanyForm;
import com.lanfang.logistics.vo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogisticsController {

    @PostMapping("/v0/logistics/createCompany")
    public ResultVo<Long> createCompany(CompanyForm companyForm) {
        return null;
    }
}
