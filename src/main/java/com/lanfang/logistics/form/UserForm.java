package com.lanfang.logistics.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

public class UserForm {

    @NotEmpty(message = "姓名不能为空")
    private String name;
    private String phone;
    private MultipartFile idCardFront;
    private MultipartFile idCardBack;

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

    public MultipartFile getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(MultipartFile idCardFront) {
        this.idCardFront = idCardFront;
    }

    public MultipartFile getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(MultipartFile idCardBack) {
        this.idCardBack = idCardBack;
    }
}
