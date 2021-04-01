package com.tydh.sxdh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tydh.sxdh.entity.SysMenus;
import com.tydh.sxdh.entity.SysPlace;
import com.tydh.sxdh.entity.SysRoleMenus;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysRoleMenusService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 角色与菜单对应关系 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-04-01
 */
@RestController
@RequestMapping("/sys-role-menus")
public class SysRoleMenusController
{
    @Autowired
    private SysRoleMenusService sysRoleMenusService;

    @PostMapping("/add")
    public Result addSysRoleMenus(String role_id, HttpServletRequest request)
    {
        //多选框中选择得菜单功能
        String[] split = request.getParameter("menuslist").split(",");

        sysRoleMenusService.getBaseMapper().delete(new LambdaQueryWrapper<SysRoleMenus>().eq(SysRoleMenus::getRoleId,role_id));

        for (String s :split)
        {
            SysRoleMenus sysRoleMenus = new SysRoleMenus();

            sysRoleMenus.setRoleId(role_id);
            sysRoleMenus.setMenuId(s);

            sysRoleMenusService.save(sysRoleMenus);
        }
        return Result.success();
    }
}

