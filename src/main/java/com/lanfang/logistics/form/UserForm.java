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
    private MultipartFile idCardFrontFile;

    @ApiModelProperty("身份证反面图片")
    private MultipartFile idCardBackFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MultipartFile getIdCardFrontFile() {
        return idCardFrontFile;
    }

    public void setIdCardFrontFile(MultipartFile idCardFrontFile) {
        this.idCardFrontFile = idCardFrontFile;
    }

    public MultipartFile getIdCardBackFile() {
        return idCardBackFile;
    }

    public void setIdCardBackFile(MultipartFile idCardBackFile) {
        this.idCardBackFile = idCardBackFile;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", idCardFrontFile=" + idCardFrontFile +
                ", idCardBackFile=" + idCardBackFile +
                '}';
    }
}
