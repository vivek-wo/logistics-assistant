package com.lanfang.logistics.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@ApiModel("添加用户的表单数据")
public class UserForm {

    @ApiModelProperty("姓名")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @ApiModelProperty("手机号码")
    @NotEmpty(message = "手机号码不能为空")
    private String phone;

    @ApiModelProperty("身份证正面图片")
    private MultipartFile idCardFront;

    @ApiModelProperty("身份证反面图片")
    private MultipartFile idCardBack;
}
