package com.tydh.sxdh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tydh.sxdh.entity.SysOrganize;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzb
 * @since 2021-03-17
 */
public interface SysOrganizeMapper extends BaseMapper<SysOrganize> {


    IPage<SysOrganize> selectPageVo(Page<?> page, Integer state);
}
