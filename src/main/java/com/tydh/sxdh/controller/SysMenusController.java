package com.tydh.sxdh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tydh.sxdh.entity.SysMenus;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 资源管理 前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-04-01
 */
@RestController
@RequestMapping("/sys-menus")
public class SysMenusController {

    @Autowired
    private SysMenusService sysMenusService;

    @RequestMapping("/selectAll")
    public Result selectAll()
    {
        List<SysMenus> sysMenus1 = sysMenusService.getBaseMapper().selectList(new LambdaQueryWrapper<SysMenus>()
                .orderByAsc(SysMenus::getId));

        return Result.success(sysMenus1);
    }
}

