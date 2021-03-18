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
@TableName("t_departure")
public class Departure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发车Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 专线Id
     */
    @TableField("dedicatedLineId")
    private Long dedicatedLineId;

    /**
     * 发车时间
     */
    @TableField("startDepartureTime")
    private LocalDateTime startDepartureTime;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
