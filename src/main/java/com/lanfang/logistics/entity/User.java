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
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 用户头像路径
     */
    @TableField("photoPath")
    private String photoPath;

    /**
     * 用户身份证正面路径
     */
    @TableField("idcardFrontPath")
    private String idcardFrontPath;

    /**
     * 用户身份证反面路径
     */
    @TableField("idcardBackPath")
    private String idcardBackPath;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
