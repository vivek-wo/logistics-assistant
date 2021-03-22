package com.lanfang.logistics.entity;

import com.baomidou.mybatisplus.annotation.*;

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
@TableName("t_company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    public Company() {
    }

    public Company(String name, String region, String address, Long legalUserId) {
        this.name = name;
        this.region = region;
        this.address = address;
        this.legalUserId = legalUserId;
    }

    /**
     * 公司Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 地区
     */
    private String region;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 营业执照图片路径
     */
    @TableField("licensePath")
    private String licensePath;

    /**
     * 公司门头照路径
     */
    @TableField("doorImagePath")
    private String doorImagePath;

    /**
     * 道路运输许可证图片路径
     */
    @TableField("roadLicensePath")
    private String roadLicensePath;

    /**
     * 公司法人Id
     */
    @TableField("legalUserId")
    private Long legalUserId;

    /**
     * 创建时间
     */
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;


}
