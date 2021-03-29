package com.tydh.sxdh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tydh.sxdh.entity.*;
import com.tydh.sxdh.mapper.SysOrganizeMapper;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysDeviceService;
import com.tydh.sxdh.service.SysOrganizeService;
import com.tydh.sxdh.service.SysPlaceService;
import com.tydh.sxdh.service.SysWorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    private SysWorkshopService sysWorkshopService;

    @Autowired
    private SysOrganizeMapper sysOrganizeMapper;

    @Autowired
    private SysPlaceService sysPlaceService;

    @Autowired
    private SysDeviceService sysDeviceService;

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

    @RequestMapping(value = "/selectAllforEasyuidata",method = {RequestMethod.GET})
    public List<EasyuiTreeData> selectAllforEasyuidata()
    {
            List<SysOrganize> saveList = sysOrganizeService.list();
            EasyuiTreeData easyuiTreeData;
            EasyuiTreeData easyuiTreeData1;
            EasyuiTreeData easyuiTreeData2;
            EasyuiTreeData easyuiTreeData3;
            List<EasyuiTreeData> easyuiTreeDataList = new ArrayList<>();
            List<EasyuiTreeData> easyuiTreeDataList1;
            List<EasyuiTreeData> easyuiTreeDataList2;
            List<EasyuiTreeData> easyuiTreeDataList3;


            for (SysOrganize sysOrganize:saveList)
            {
                easyuiTreeDataList1 = new ArrayList<>();


                easyuiTreeData = new EasyuiTreeData();
                easyuiTreeData.setId(sysOrganize.getFId());
                easyuiTreeData.setText(sysOrganize.getFOrganizeName());
                easyuiTreeData.setParentId(null);
                List<SysWorkshop> sysWorkshopList = sysWorkshopService.list(new LambdaQueryWrapper<SysWorkshop>().eq(SysWorkshop::getOrgnizeId, sysOrganize.getFId()));

                for (SysWorkshop sysWorkshop:sysWorkshopList)
                {
                    easyuiTreeDataList2 = new ArrayList<>();

                    easyuiTreeData1 = new EasyuiTreeData();
                    easyuiTreeData1.setId(sysWorkshop.getId());
                    easyuiTreeData1.setText(sysWorkshop.getWorkshopName());
                    easyuiTreeData1.setParentId(sysWorkshop.getOrgnizeId());


                    easyuiTreeDataList1.add(easyuiTreeData1);
                    easyuiTreeData.setChildren(easyuiTreeDataList1);

                    List<SysPlace> sysPlaceList = sysPlaceService.list(new LambdaQueryWrapper<SysPlace>().eq(SysPlace::getWorkshopId, sysWorkshop.getId()));

                    for (SysPlace sysPlace:sysPlaceList)
                    {
                        easyuiTreeDataList3 = new ArrayList<>();

                        easyuiTreeData2 = new EasyuiTreeData();
                        easyuiTreeData2.setId(sysPlace.getId());
                        easyuiTreeData2.setText(sysPlace.getPlaceName());
                        easyuiTreeData2.setParentId(sysPlace.getWorkshopId());

                        easyuiTreeDataList2.add(easyuiTreeData2);
                        easyuiTreeData1.setChildren(easyuiTreeDataList2);

                        List<SysDevice> sysDeviceList = sysDeviceService.list(new LambdaQueryWrapper<SysDevice>().eq(SysDevice::getPlaceId, sysPlace.getId()));
                        for (SysDevice sysDevice:sysDeviceList)
                        {
                            easyuiTreeData3 = new EasyuiTreeData();
                            easyuiTreeData3.setId(sysDevice.getId());
                            easyuiTreeData3.setText(sysDevice.getDeviceName());
                            easyuiTreeData3.setParentId(sysDevice.getPlaceId());
                            easyuiTreeData3.setChildren(null);

                            easyuiTreeDataList3.add(easyuiTreeData3);
                            easyuiTreeData2.setChildren(easyuiTreeDataList3);
                        }
                    }
                }

                easyuiTreeDataList.add(easyuiTreeData);
            }
            return easyuiTreeDataList;
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

