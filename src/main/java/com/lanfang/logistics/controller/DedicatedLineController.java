package com.lanfang.logistics.controller;


import com.lanfang.logistics.entity.Company;
import com.lanfang.logistics.entity.DedicatedLine;
import com.lanfang.logistics.entity.Site;
import com.lanfang.logistics.form.DLineForm;
import com.lanfang.logistics.service.ICompanyService;
import com.lanfang.logistics.service.IDedicatedLineService;
import com.lanfang.logistics.service.ISiteService;
import com.lanfang.logistics.vo.CompanySiteVo;
import com.lanfang.logistics.vo.DedicatedLineVo;
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

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Api("专线管理")
@RestController
@RequestMapping("/api")
public class DedicatedLineController {

    private IDedicatedLineService dedicatedLineService;

    private ISiteService siteService;

    private ICompanyService companyService;

    @Autowired
    public DedicatedLineController(ICompanyService companyService, ISiteService siteService,
                                   IDedicatedLineService dedicatedLineService) {
        this.companyService = companyService;
        this.siteService = siteService;
        this.dedicatedLineService = dedicatedLineService;
    }

    @ApiOperation("创建专线")
    @PostMapping("/v0/logistics/createDedicatedLine")
    public ResultVo<String> createDedicatedLine(DLineForm dLineForm) {
        Company company = this.companyService.getById(dLineForm.getCompanyId());
        if (company == null) {
            return ResultVo.errorWidthService("公司不存在");
        }
        if (!checkSiteExisted(dLineForm.getStartSiteId(), dLineForm.getCompanyId())) {
            return ResultVo.errorWidthService("开始网点不存在");
        }
        if (!checkSiteExisted(dLineForm.getEndSiteId(), dLineForm.getCompanyId())) {
            return ResultVo.errorWidthService("到达网点不存在");
        }
        if (dLineForm.getMiddleSiteIds() != null) {
            String regex = "^\\d+(,\\d+)*$";
            boolean result = Pattern.matches(regex, dLineForm.getMiddleSiteIds());
            if (!result) {
                return ResultVo.errorWidthService("中间网点格式不正确");
            }
            String[] siteIds = dLineForm.getMiddleSiteIds().split(",");
            for (String s : siteIds) {
                if (!checkSiteExisted(Long.parseLong(s), dLineForm.getCompanyId())) {
                    return ResultVo.errorWidthService("中间网点" + s + "不存在");
                }
            }
        }
        DedicatedLine dedicatedLine = new DedicatedLine();
        BeanUtils.copyProperties(dLineForm, dedicatedLine);
        this.dedicatedLineService.save(dedicatedLine);
        return ResultVo.successOnlyMessage("创建成功");
    }

    private boolean checkSiteExisted(long siteId, long companyId) {
        Site site = this.siteService.getById(siteId);
        return site != null && site.getCompanyId() == companyId;
    }

    @ApiOperation("查询专线")
    @GetMapping("/v0/logistics/queryDedicatedLine")
    public ResultVo<List<DedicatedLineVo>> queryDedicatedLine(
            @Validated @Min(value = 1, message = "公司Id不能为空") long companyId, String region) {
        List<DedicatedLine> lineList = this.dedicatedLineService.queryByCompanyId(companyId);
        List<DedicatedLineVo> dedicatedLineVoList = new ArrayList<>();
        for (DedicatedLine line : lineList) {
            DedicatedLineVo dedicatedLineVo = new DedicatedLineVo();
            dedicatedLineVo.setStartSite(querySiteById(line.getStartSiteId()));
            dedicatedLineVo.setEndSite(querySiteById(line.getEndSiteId()));
            if (line.getMiddleSiteIds() != null) {
                String[] middleIds = line.getMiddleSiteIds().split(",");
                List<CompanySiteVo> middleCSVoList = new ArrayList<>();
                dedicatedLineVo.setMiddleSites(middleCSVoList);
                for (String id : middleIds) {
                    middleCSVoList.add(querySiteById(Long.parseLong(id)));
                }
            }
            dedicatedLineVoList.add(dedicatedLineVo);
        }
        return ResultVo.successWidthBody(dedicatedLineVoList);
    }

    private CompanySiteVo querySiteById(long id) {
        CompanySiteVo companySiteVo = new CompanySiteVo();
        Site site = this.siteService.getById(id);
        BeanUtils.copyProperties(site, companySiteVo);
        return companySiteVo;
    }
}
