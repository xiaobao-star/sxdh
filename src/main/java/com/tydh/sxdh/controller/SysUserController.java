package com.tydh.sxdh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tydh.sxdh.entity.SysUser;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysUserService;
import com.tydh.sxdh.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzb
 * @since 2021-03-11
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController
{
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/userLogin")
    public Result sysUserLogin(String username,String password)
    {
        try
        {
            List<SysUser> userByLogin = sysUserService.findUserByLogin(username, password);
            return userByLogin.size() != 0 ? Result.success(userByLogin):Result.error("用户名或者密码错误");
        }catch (Exception e)
        {
            return Result.error(e);
        }
    }
}

