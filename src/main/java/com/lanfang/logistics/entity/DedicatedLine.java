package com.lanfang.logistics.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
    @TableField("createTime")
    private LocalDateTime createTime;


}
