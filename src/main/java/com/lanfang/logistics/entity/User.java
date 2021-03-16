package com.lanfang.logistics.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class User {
    private long id;
    private String account;
    private String name;
    private String phone;
    @TableField(value = "photo_path")
    private String photoPath;
    private String idCardFrontPath;
    private String idCardBackPath;
    private int type;
    private Date createTime;
}
