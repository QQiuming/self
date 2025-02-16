package com.example.self.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.example.self.base.datasource.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author qiuming
 * @since 2025-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    private String loginName;

    private String password;

    private String nickName;

    private String orgId;



}
