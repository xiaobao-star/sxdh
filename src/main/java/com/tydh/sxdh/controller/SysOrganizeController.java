package com.tydh.sxdh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tydh.sxdh.entity.SysOrganize;
import com.tydh.sxdh.mapper.SysOrganizeMapper;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysOrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-03-17
 */
@RestController
@RequestMapping("/sys-organize")
public class SysOrganizeController {

    @Autowired
    private SysOrganizeService sysOrganizeService;

    @Autowired
    private SysOrganizeMapper sysOrganizeMapper;

    @RequestMapping("/add")
    public Result addOrgnize(SysOrganize sysOrganize)
    {
        try
        {
            sysOrganizeService.save(sysOrganize);
            return Result.success(sysOrganize);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/update")
    public Result updateOrgnize(SysOrganize sysOrganize)
    {
        try
        {
            sysOrganizeService.saveOrUpdate(sysOrganize);
            return Result.success();
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/selectAll")
    public Result selectAllOrgnize()
    {
        try
        {
            List<SysOrganize> saveList = sysOrganizeService.list();
            return Result.success(saveList);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/selectbyid")
    public Result selectOrgnizeById(@RequestParam("id") String fid)
    {
        try
        {
            SysOrganize saveList = sysOrganizeService.getBaseMapper().selectById(fid);
            return Result.success(saveList);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/deletebyid")
    public Result deleteOrgnizeById(@RequestParam("id") String fid)
    {
        try
        {
            sysOrganizeService.removeById(fid);
            return Result.success();
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    //分页查询
    @RequestMapping("/findsysorgpage")
    public Result selectUserPage(Integer current, Integer size)
    {
        try
        {
            return Result.success(sysOrganizeMapper.selectPageVo(new Page<>(current,size), null));
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }
}

