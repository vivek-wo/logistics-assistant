package com.lanfang.logistics.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author vivek
 * @since 2021-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_dedicated_line")
public class DedicatedLine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专线Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 开始网点Id
     */
    @TableField("startSiteId")
    private Long startSiteId;

    /**
     * 结束网点Id
     */
    @TableField("endSiteId")
    private Long endSiteId;

    /**
     * 中间网点Id集合
     */
    @TableField("middleSiteIds")
    private String middleSiteIds;

    /**
     * 公司Id
     */
    @TableField("companyId")
    private Long companyId;

    /**
     * 创建时间
     */
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
