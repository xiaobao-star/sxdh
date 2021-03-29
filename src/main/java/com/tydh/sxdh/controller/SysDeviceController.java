package com.tydh.sxdh.controller;


import com.tydh.sxdh.entity.SysDevice;
import com.tydh.sxdh.entity.SysPlace;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysDeviceService;
import com.tydh.sxdh.service.SysPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-03-26
 */
@RestController
@RequestMapping("/sys-device")
public class SysDeviceController {

    @Autowired
    private SysPlaceService sysPlaceService;

    @Autowired
    private SysDeviceService sysDeviceService;

    @PostMapping("/add")
    public Result addWorkShop(SysDevice sysDevice)
    {
        try
        {
            sysDeviceService.save(sysDevice);
            return Result.success(sysDevice);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }

    @RequestMapping("/update")
    public Result updateOrgnize(SysDevice sysDevice)
    {
        try
        {
            boolean b = sysDeviceService.saveOrUpdate(sysDevice);
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
            List<SysDevice> sysDeviceList = sysDeviceService.list();

            for (SysDevice s:sysDeviceList)
            {
                s.setSysPlace(sysPlaceService.getById(s.getPlaceId()));
            }
            return Result.success(sysDeviceList);
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
            SysDevice sysDevice = sysDeviceService.getBaseMapper().selectById(fid);
            return Result.success(sysDevice);
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
            boolean b = sysDeviceService.removeById(fid);
            return Result.success(b);
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }
}

