package com.lanfang.logistics.controller;


import com.lanfang.logistics.form.UserForm;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Api("用户管理")
@RestController
@RequestMapping("/api")
public class UserController {

    @ApiOperation("创建用户")
    @PostMapping("/v0/user/createUser")
    public ResultVo<Long> createUser(@Validated @ApiParam(value = "用户信息") UserForm userForm) {
        return ResultVo.successWidthBody(123L);
    }
}
