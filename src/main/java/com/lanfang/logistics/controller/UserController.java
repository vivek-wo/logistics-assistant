package com.lanfang.logistics.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lanfang.logistics.configuration.PropertiesConfiguration;
import com.lanfang.logistics.entity.User;
import com.lanfang.logistics.form.UserForm;
import com.lanfang.logistics.service.IUserService;
import com.lanfang.logistics.util.UploadFileUtils;
import com.lanfang.logistics.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    private PropertiesConfiguration propertiesConfiguration;

    @Autowired
    public void setPropertiesConfiguration(PropertiesConfiguration propertiesConfiguration) {
        this.propertiesConfiguration = propertiesConfiguration;
    }

    @ApiOperation("创建用户")
    @PostMapping("/v0/user/createUser")
    public ResultVo<Long> createUser(@Validated @ApiParam(value = "用户信息") UserForm userForm, HttpServletRequest request) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", userForm.getPhone());
        User user = this.userService.getOne(queryWrapper, false);
        if (user == null) {
            user = new User(userForm.getPhone(), "123456", userForm.getName(), userForm.getPhone());
        } else {
            user.setName(userForm.getName());
        }
        if (userForm.getIdCardFrontFile() != null && userForm.getIdCardBackFile() != null) {
            //TODO 替换本地路径
            String basePath = request.getServletContext().getRealPath(propertiesConfiguration.getUploadIDPhotoPath());
            try {
                String frontPath = UploadFileUtils.saveImageFile(basePath, userForm.getIdCardFrontFile());
                user.setIdcardFrontPath(frontPath);
                String backPath = UploadFileUtils.saveImageFile(basePath, userForm.getIdCardBackFile());
                user.setIdcardBackPath(backPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.userService.saveOrUpdate(user);
        return ResultVo.successWidthBody(user.getId());
    }
}
