package com.lanfang.logistics.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@ApiModel("创建公司的表单数据")
@Data
public class CompanyForm {

    @ApiModelProperty("公司法人Id")
//    @Min(value = 1, message = "公司法人Id错误")
    private long legalUserId;

    @ApiModelProperty("公司名称")
//    @NotEmpty(message = "公司名称不能为空")
    private String name;

    @ApiModelProperty("公司所在经度")
    private double lng;

    @ApiModelProperty("公司所在纬度")
    private double lat;

    @ApiModelProperty("公司所在地区")
//    @NotEmpty(message = "公司所在地区不能为空")
    private String region;

    @ApiModelProperty("公司所在详细地址")
//    @NotEmpty(message = "公司地址不能为空")
    private String address;

    @ApiModelProperty("公司营业执照图片")
    private MultipartFile licenseFile;

    @ApiModelProperty("公司门头照图片")
    private MultipartFile doorImageFile;

    @ApiModelProperty("公司道路运输许可证图片")
    private MultipartFile roadTransportFile;

}
