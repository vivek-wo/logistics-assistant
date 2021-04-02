package com.lanfang.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanfang.logistics.entity.DedicatedLine;
import com.lanfang.logistics.entity.Departure;
import com.lanfang.logistics.service.IDedicatedLineService;
import com.lanfang.logistics.service.IDepartureService;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Api("发车管理")
@RestController
@RequestMapping("/api")
public class DepartureController {

    private final IDepartureService departureService;

    private final IDedicatedLineService dedicatedLineService;

    @Autowired
    public DepartureController(IDepartureService departureService, IDedicatedLineService dedicatedLineService) {
        this.departureService = departureService;
        this.dedicatedLineService = dedicatedLineService;
    }

    @ApiOperation("新增发车")
    @PostMapping("/v0/logistics/createDepartureTime")
    public ResultVo<String> createDepartureTime(long dedicatedLineId, String departureTime) {
        Departure departure = new Departure();
        departure.setDedicatedLineId(dedicatedLineId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            departure.setStartDepartureTime(simpleDateFormat.parse(departureTime));
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultVo.errorWidthService("时间错误");
        }
        this.departureService.save(departure);
        return ResultVo.successOnlyMessage("新增成功");
    }

    @ApiOperation("查询发车时间")
    @GetMapping("/v0/logistics/getDepartureTime")
    public ResultVo<List<Departure>> getDepartureTime(long dedicatedLineId, String startDepartureTime, String endDepartureTime) {
        DedicatedLine dedicatedLine = this.dedicatedLineService.getById(dedicatedLineId);
        if (dedicatedLine == null) {
            return ResultVo.errorWidthService("dedicatedLineId不存在");
        }
        Date startDateTime = null;
        Date endDateTime = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (startDepartureTime != null) {
            try {
                startDateTime = simpleDateFormat.parse(startDepartureTime);
            } catch (ParseException e) {
                e.printStackTrace();
                return ResultVo.errorWidthService("时间错误");
            }
        }
        if (endDepartureTime != null) {
            try {
                endDateTime = simpleDateFormat.parse(endDepartureTime);
            } catch (ParseException e) {
                e.printStackTrace();
                return ResultVo.errorWidthService("时间错误");
            }
        }
        QueryWrapper<Departure> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dedicatedLineId", dedicatedLineId);
        if (startDateTime != null) {
            queryWrapper.ge("startDepartureTime", startDateTime);
        }
        if (endDateTime != null) {
            queryWrapper.lt("startDepartureTime", endDateTime);
        }
        queryWrapper.orderByAsc("startDepartureTime");
        List<Departure> list = this.departureService.list(queryWrapper);
        return ResultVo.successWidthBody(list);
    }

}
