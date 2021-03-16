package com.lanfang.logistics.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

@ApiModel("创建公司的表单数据")
public class CompanyForm {

    @ApiModelProperty("公司法人Id")
    private long legalUserId;

    @ApiModelProperty("公司名称")
    private String name;

    @ApiModelProperty("公司所在经度")
    private double longitude;

    @ApiModelProperty("公司所在纬度")
    private double latitude;

    @ApiModelProperty("公司所在地区")
    private String region;

    @ApiModelProperty("公司所在详细地址")
    private String address;

    @ApiModelProperty("公司营业执照图片")
    private MultipartFile licenseFile;

    @ApiModelProperty("公司门头照图片")
    private MultipartFile doorImageFile;

    @ApiModelProperty("公司道路运输许可证图片")
    private MultipartFile roadTransportFile;

}
