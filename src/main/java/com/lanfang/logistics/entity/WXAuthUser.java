package com.lanfang.logistics.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_wxauth_user")
public class WXAuthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户Id
     */
    @TableField("userId")
    private Long userId;

    /**
     * 微信code
     */
    private String code;

    /**
     * 微信openId
     */
    @TableField("openId")
    private String openId;

    /**
     * 微信昵称
     */
    private String nick;

    @TableField("photoPath")
    private String photoPath;


}
