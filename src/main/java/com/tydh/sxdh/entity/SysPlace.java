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
 * @since 2021-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_PLACE")
public class SysPlace implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 场地编号
     */
    @TableField("PLACE_CODE")
    private String placeCode;

    /**
     * 场地名称
     */
    @TableField("PLACE_NAME")
    private String placeName;

    /**
     * 关联车间表主键
     */
    @TableField("WORKSHOP_ID")
    private String workshopId;


    @TableField(exist = false)
    private SysWorkshop sysWorkshop;
}
