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

@Api("用户管理")
@RestController
@RequestMapping("/api")
public class UserController {

    @ApiOperation("创建用户")
    @PostMapping("/v0/user/createUser")
    public ResultVo<Long> createUser(@Validated @ApiParam(value = "用户信息") UserForm userForm) {
        return ResultVo.success(123L);
    }
}
