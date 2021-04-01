package com.tydh.sxdh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author zzb
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_ROLES")
public class SysRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 角色名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 备注
     */
    @TableField("NOTE")
    private String note;

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
