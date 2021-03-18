package com.lanfang.logistics.controller;


import com.lanfang.logistics.form.DLineForm;
import com.lanfang.logistics.vo.DedicatedLineVo;
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
@Api("专线管理")
@RestController
@RequestMapping("/api")
public class DedicatedLineController {

    @ApiOperation("创建专线")
    @PostMapping("/v0/logistics/createDedicatedLine")
    public ResultVo<String> createDedicatedLine(DLineForm dLineForm) {
        return null;
    }

    @ApiOperation("查询专线")
    @GetMapping("/v0/logistics/queryDedicatedLine")
    public ResultVo<List<DedicatedLineVo>> queryDedicatedLine(long companyId, String region) {
        return null;
    }
}
