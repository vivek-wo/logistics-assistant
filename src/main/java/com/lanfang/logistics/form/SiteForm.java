package com.lanfang.logistics.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("创建公司网点的表单数据")
public class SiteForm {

    @ApiModelProperty("公司标识Id")
    @Min(value = 1, message = "公司Id错误")
    private long companyId;

    @ApiModelProperty("网点名称")
    @NotEmpty(message = "网点名称不能为空")
    private String name;

    @ApiModelProperty("网点所在经度")
    private double lng;

    @ApiModelProperty("网点所在纬度")
    private double lat;

    @ApiModelProperty("网点所在地区")
    @NotEmpty(message = "网点地区不能为空")
    private String region;

    @ApiModelProperty("网点所在详细地址")
    @NotEmpty(message = "网点详细地址不能为空")
    private String address;

    @ApiModelProperty("网点联系人")
    @NotEmpty(message = "网点联系人不能为空")
    private String contactUser;

    @ApiModelProperty("网点联系电话")
    @NotEmpty(message = "网点联系电话不能为空")
    private String contactPhone;

    @ApiModelProperty("网点照片")
    private MultipartFile photoFile;

    @ApiModelProperty("网点营业时间")
    private String businessTime;

}
