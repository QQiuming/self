package com.example.self.base.datasource.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @descriptions: BaseEntity
 * @author: qiuming
 * @date: 2025/1/18 12:50
 * @version: 1.0
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String createBy;

    private String updateBy;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer lockVersion;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteFlag;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
