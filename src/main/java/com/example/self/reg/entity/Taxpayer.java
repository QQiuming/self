package com.example.self.reg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.example.self.base.datasource.entity.BaseEntity;
import com.example.self.base.datasource.handler.AesEncryptTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qiuming
 * @since 2025-01-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName(value = "reg_taxpayer",autoResultMap = true)
@ApiModel(value = "Taxpayer对象", description = "")
public class Taxpayer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("biz_id")
    private String bizId;

    @TableField("biz_tin")
    private String bizTin;

    @TableField("taxpayer_name")
    private String taxpayerName;

    @TableField("taxpayer_type")
    private String taxpayerType;

    @TableField(value = "id_no",typeHandler = AesEncryptTypeHandler.class)
    private String idNo;

    @TableField(value = "telephone",typeHandler = AesEncryptTypeHandler.class)
    private String telephone;

    @TableField("org_id")
    private String orgId;


}
