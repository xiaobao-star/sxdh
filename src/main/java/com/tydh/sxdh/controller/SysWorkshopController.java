package com.tydh.sxdh.controller;


import com.tydh.sxdh.entity.SysOrganize;
import com.tydh.sxdh.entity.SysWorkshop;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysOrganizeService;
import com.tydh.sxdh.service.SysWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-03-23
 */
@RestController
@RequestMapping("/sys-workshop")
public class SysWorkshopController {

    @Autowired
    private SysWorkshopService sysWorkshopService;

    @Autowired
    private SysOrganizeService sysOrganizeService;

    @PostMapping("/add")
    public Result addWorkShop(SysWorkshop sysWorkshop)
    {
        try
        {
            sysWorkshopService.save(sysWorkshop);
            return Result.success(sysWorkshop);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/update")
    public Result updateOrgnize(SysWorkshop sysWorkshop)
    {
        try
        {
            boolean b = sysWorkshopService.saveOrUpdate(sysWorkshop);
            return Result.success(b);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    /**
     * 查询车间信息包含上级机构信息
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectWorkShop()
    {
        try
        {
            List<SysWorkshop> sysWorkshopList = sysWorkshopService.list();

            for (SysWorkshop s:sysWorkshopList)
            {
                s.setSysOrganize(sysOrganizeService.getById(s.getOrgnizeId()));
            }
            return Result.success(sysWorkshopList);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/selectbyid")
    public Result selectWorkShopById(@RequestParam("id") String fid)
    {
        try
        {
            SysWorkshop save = sysWorkshopService.getBaseMapper().selectById(fid);
            return Result.success(save);
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
            boolean b = sysWorkshopService.removeById(fid);
            return Result.success(b);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }
}

