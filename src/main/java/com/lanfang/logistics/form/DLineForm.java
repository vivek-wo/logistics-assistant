package com.lanfang.logistics.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("创建专线的表单数据")
public class DLineForm {

    @ApiModelProperty("公司标识Id")
    private long companyId;

    @ApiModelProperty("收货联系人")
    private String recUserName;

    @ApiModelProperty("收货联系电话")
    private String recUserPhone;

    @ApiModelProperty("收货营业时间")
    private String recTime;

    @ApiModelProperty("收货地区")
    private String recRegion;

    @ApiModelProperty("收货地址")
    private String recAdress;

    @ApiModelProperty("提货联系人")
    private String pickUserName;

    @ApiModelProperty("提货联系电话")
    private String pickUserPhone;

    @ApiModelProperty("提货营业时间")
    private String pickTime;

    @ApiModelProperty("提货地区")
    private String pickRegion;

    @ApiModelProperty("提货地址")
    private String pickAdress;

}
