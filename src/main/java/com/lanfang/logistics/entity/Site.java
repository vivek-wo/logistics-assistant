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
@TableName("t_site")
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 网点Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 网点名称
     */
    private String name;

    /**
     * 网点经度
     */
    private String lng;

    /**
     * 网点纬度
     */
    private String lat;

    /**
     * 网点地区
     */
    private String region;

    /**
     * 网点地址
     */
    private String address;

    /**
     * 网点联系人
     */
    @TableField("contactUser")
    private String contactUser;

    /**
     * 网点联系电话
     */
    @TableField("contactPhone")
    private String contactPhone;

    /**
     * 网点开始营业时间
     */
    @TableField("startTime")
    private LocalDateTime startTime;

    /**
     * 网点结束营业时间
     */
    @TableField("endTime")
    private LocalDateTime endTime;

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