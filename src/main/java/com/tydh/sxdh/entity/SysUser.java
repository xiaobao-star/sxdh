package com.tydh.sxdh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzb
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_USER")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表主键
     */
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 操作员代码
     */
    @TableField("F_USERCODE")
    private String fUsercode;

    /**
     * 操作员姓名
     */
    @TableField("F_USERNAME")
    private String fUsername;

    /**
     * 密码
     */
    @TableField("F_PASSWORD")
    private String fPassword;

    /**
     * 手机
     */
    @TableField("F_MOB")
    private String fMob;

    /**
     * 描述
     */
    @TableField("F_DESCRIPTION")
    private String fDescription;


    @TableField(exist = false)
    private SysUserRoles sysUserRoles;

    @TableField(exist = false)
    private SysRoles sysRoles;
}
