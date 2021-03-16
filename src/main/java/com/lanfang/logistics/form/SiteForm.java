package com.lanfang.logistics.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

@ApiModel("创建公司网点的表单数据")
public class SiteForm {

    @ApiModelProperty("公司标识Id")
    private long companyId;

    @ApiModelProperty("网点名称")
    private String name;

    @ApiModelProperty("网点所在经度")
    private double longitude;

    @ApiModelProperty("网点所在纬度")
    private double latitude;

    @ApiModelProperty("网点所在地区")
    private String region;

    @ApiModelProperty("网点所在详细地址")
    private String address;

    @ApiModelProperty("网点联系人")
    private String contactUserName;

    @ApiModelProperty("网点联系电话")
    private String contactUserPhone;

    @ApiModelProperty("网点照片")
    private MultipartFile photo;

    @ApiModelProperty("网点营业开始时间")
    private String startTime;

    @ApiModelProperty("网点营业结束时间")
    private String endTime;

}
