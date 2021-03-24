package com.lanfang.logistics.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@ApiModel("创建专线的表单数据")
public class DLineForm {

    /**
     * 开始网点Id
     */
    @ApiModelProperty("开始网点Id")
    @Min(value = 1, message = "开始网点不能为空")
    private Long startSiteId;

    /**
     * 结束网点Id
     */
    @ApiModelProperty("到达网点Id")
    @Min(value = 1, message = "到达网点不能为空")
    private Long endSiteId;

    /**
     * 中间网点Id集合
     */
    @ApiModelProperty("中间网点Id")
    private String middleSiteIds;

    /**
     * 公司Id
     */
    @ApiModelProperty("公司Id")
    @Min(value = 1, message = "公司不能为空")
    private Long companyId;
}
