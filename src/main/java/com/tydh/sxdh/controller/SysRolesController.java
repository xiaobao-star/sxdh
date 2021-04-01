package com.tydh.sxdh.controller;


import com.tydh.sxdh.JUtils.date.DateUtils;
import com.tydh.sxdh.entity.SysOrganize;
import com.tydh.sxdh.entity.SysRoles;
import com.tydh.sxdh.entity.SysWorkshop;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/sys-roles")
public class SysRolesController {

    @Autowired
    private SysRolesService sysRolesService;

    @GetMapping("/selectAll")
    public Result selectWorkShop()
    {
        List<SysRoles> sysRolesList = sysRolesService.list().stream().sorted(Comparator.comparing(SysRoles::getCreatedtime)).collect(Collectors.toList());;

        return Result.success(sysRolesList);
    }

    @GetMapping("/selectbyid")
    public Result selectWorkShopOneById(String id)
    {
        SysRoles sysRoles = sysRolesService.getBaseMapper().selectById(id);
        return Result.success(sysRoles);
    }

    @RequestMapping("/add")
    public Result addRole(SysRoles sysRoles)
    {
        sysRoles.setCreatedtime(DateUtils.getCurrentDate());
        sysRolesService.save(sysRoles);
        return Result.success(sysRoles);
    }

    @RequestMapping("/update")
    public Result updateRole(SysRoles sysRoles)
    {
        sysRoles.setModifiedtime(DateUtils.getCurrentDate());
        sysRolesService.saveOrUpdate(sysRoles);
        return Result.success();
    }

    @RequestMapping("/deletebyid")
    public Result deleteRoleById(String id)
    {
        sysRolesService.removeById(id);
        return Result.success();
    }
}

