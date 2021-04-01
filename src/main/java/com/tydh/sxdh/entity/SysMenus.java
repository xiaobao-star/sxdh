package com.tydh.sxdh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资源管理
 * </p>
 *
 * @author zzb
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_MENUS")
public class SysMenus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 资源名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 资源URL
     */
    @TableField("URL")
    private String url;

    /**
     * 类型     1：菜单   2：按钮
     */
    @TableField("TYPE")
    private String type;

    /**
     * 排序
     */
    @TableField("SORT")
    private String sort;

    /**
     * 备注
     */
    @TableField("NOTE")
    private String note;

    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField("PARENTID")
    private String parentid;

    /**
     * 授权(如：user:create)
     */
    @TableField("PERMISSION")
    private String permission;

    /**
     * 创建时间
     */
    @TableField("CREATEDTIME")
    private Date createdtime;

    /**
     * 修改时间
     */
    @TableField("MODIFIEDTIME")
    private Date modifiedtime;

    /**
     * 创建用户
     */
    @TableField("CREATEDUSER")
    private String createduser;

    /**
     * 修改用户
     */
    @TableField("MODIFIEDUSER")
    private String modifieduser;


}
