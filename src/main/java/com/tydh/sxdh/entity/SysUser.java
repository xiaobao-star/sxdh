package com.tydh.sxdh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzb
 * @since 2021-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_USER")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表主键
     */
    @TableId(value = "F_ID", type = IdType.ASSIGN_UUID)
    private Integer fId;

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
     * 头像
     */
    @TableField("F_HEADICON")
    private String fHeadicon;

    /**
     * 手机
     */
    @TableField("F_MOB")
    private String fMob;

    /**
     * 邮箱
     */
    @TableField("F_EMAIL")
    private String fEmail;

    /**
     * 微信
     */
    @TableField("F_WECHAT")
    private String fWechat;

    /**
     * 组织表主键
     */
    @TableField("F_ORGID")
    private Integer fOrgid;

    /**
     * 车间表主键
     */
    @TableField("F_SHOPID")
    private Integer fShopid;

    /**
     * 角色表主键
     */
    @TableField("F_ROLEID")
    private Integer fRoleid;

    /**
     * 班组表主键
     */
    @TableField("F_TEAMID")
    private Integer fTeamid;

    /**
     * 是否为管理员
     */
    @TableField("F_ISADMIN")
    private Integer fIsadmin;

    /**
     * 描述
     */
    @TableField("F_DESCRIPTION")
    private String fDescription;


}
