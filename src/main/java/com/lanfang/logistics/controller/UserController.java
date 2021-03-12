package com.lanfang.logistics.controller;

import com.lanfang.logistics.form.UserForm;
import com.lanfang.logistics.vo.ResultVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/v0/user/createUser")
    public ResultVo<Long> createUser(@Validated UserForm userForm) {
        return ResultVo.success(123L);
    }
}
