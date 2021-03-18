package com.lanfang.logistics.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地区Id
     */
    private Long id;

    /**
     * 地址编码
     */
    private String adcode;

    /**
     * 地址
     */
    private String address;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 格式化地址
     */
    private String formatted;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lng;

    /**
     * 省
     */
    private String province;


}
