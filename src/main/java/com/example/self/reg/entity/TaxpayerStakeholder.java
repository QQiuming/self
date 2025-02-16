package com.example.self.reg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
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
 * @since 2025-01-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("reg_taxpayer_stakeholder")
@ApiModel(value = "TaxpayerStakeholder对象", description = "")
public class TaxpayerStakeholder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("taxpayer_id")
    private String taxpayerId;

    @TableField("stakeholder_name")
    private String stakeholderName;

    @TableField("id_no")
    private String idNo;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("create_by")
    private String createBy;

    @TableField("update_by")
    private String updateBy;

    @TableField("lock_version")
    private Integer lockVersion;

    @TableField("delete_flag")
    private Integer deleteFlag;
}
