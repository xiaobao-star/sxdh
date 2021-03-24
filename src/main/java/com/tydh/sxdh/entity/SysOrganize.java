package com.tydh.sxdh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzb
 * @since 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_ORGANIZE")
public class SysOrganize implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织表主键
     */
    @TableId(value = "F_ID", type = IdType.ASSIGN_UUID)
    private String fId;

    /**
     * 父级
     */
    @TableField("F_PARENTID")
    private String fParentid;

    /**
     * 父级主键
     */
    @TableField("F_ENCODE")
    private String fEncode;

    /**
     * 机构代码
     */
    @TableField("F_FULLNAME")
    private String fFullname;

    /**
     * 机构属性(中心局、揽投站等)
     */
    @TableField("F_CATEGORYID")
    private String fCategoryid;

    /**
     * 负责人
     */
    @TableField("F_MANAGERNAME")
    private String fManagername;

    /**
     * 电话
     */
    @TableField("F_TELE")
    private String fTele;

    /**
     * 手机
     */
    @TableField("F_MOB")
    private String fMob;

    /**
     * 微信
     */
    @TableField("F_WECHAT")
    private String fWechat;

    /**
     * 传真
     */
    @TableField("F_FAX")
    private String fFax;

    /**
     * 邮箱
     */
    @TableField("F_EMAIL")
    private String fEmail;

    /**
     * 区域代码主键
     */
    @TableField("F_AREAID")
    private Integer fAreaid;

    /**
     * 联系地址
     */
    @TableField("F_ADD")
    private String fAdd;

    /**
     * 有效标志
     */
    @TableField("F_ENABLEDMARK")
    private Integer fEnabledmark;

    /**
     * 描述
     */
    @TableField("F_DESCRIPTION")
    private String fDescription;

    /**
     * 机构名称
     */
    @TableField("F_ORGANIZE_NAME")
    private String fOrganizeName;
}
