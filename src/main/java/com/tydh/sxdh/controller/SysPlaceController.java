package com.tydh.sxdh.controller;


import com.tydh.sxdh.entity.SysPlace;
import com.tydh.sxdh.entity.SysWorkshop;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysOrganizeService;
import com.tydh.sxdh.service.SysPlaceService;
import com.tydh.sxdh.service.SysWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-03-25
 */
@RestController
@RequestMapping("/sys-place")
public class SysPlaceController {


    @Autowired
    private SysWorkshopService sysWorkshopService;

    @Autowired
    private SysPlaceService sysPlaceService;

    @PostMapping("/add")
    public Result addWorkShop(SysPlace SysPlace)
    {
        try
        {
            sysPlaceService.save(SysPlace);
            return Result.success(SysPlace);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/update")
    public Result updateOrgnize(SysPlace SysPlace)
    {
        try
        {
            boolean b = sysPlaceService.saveOrUpdate(SysPlace);
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
            List<SysPlace> sysPlaceList = sysPlaceService.list();

            for (SysPlace s:sysPlaceList)
            {
                s.setSysWorkshop(sysWorkshopService.getById(s.getWorkshopId()));
            }
            return Result.success(sysPlaceList);
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
            SysPlace save = sysPlaceService.getBaseMapper().selectById(fid);
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
            boolean b = sysPlaceService.removeById(fid);
            return Result.success(b);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }
}

