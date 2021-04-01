package com.tydh.sxdh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils;
import com.tydh.sxdh.entity.*;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.*;
import com.tydh.sxdh.service.impl.SysUserServiceImpl;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private SysRolesService sysRolesService;

    @Autowired
    private SysUserRolesService sysUserRolesService;

    @Autowired
    private SysRoleMenusService sysRoleMenusService;

    @Autowired
    private SysMenusService sysMenusService;

    @RequestMapping("/userLogin")
    public Result sysUserLogin(String username, String password, HttpServletRequest request)
    {
        List<SysUser> userByLogin = sysUserService.findUserByLogin(username, password);
        request.getSession().setAttribute("user",userByLogin.get(0));

        request.getServletContext().setAttribute("user",userByLogin.get(0));

        return userByLogin.size() != 0 ? Result.success(userByLogin):Result.error("用户名或者密码错误");
    }

    @RequestMapping("/findautorization")
    public Result findautorization( HttpServletRequest request)
    {

        SysUser user = (SysUser)request.getServletContext().getAttribute("user");
        SysUserRoles sysUserRoles = sysUserRolesService.getBaseMapper().selectOne(new LambdaQueryWrapper<SysUserRoles>().eq(SysUserRoles::getUserId, user.getId()));

        List<SysRoleMenus> sysRoleMenus = sysRoleMenusService.getBaseMapper().selectList(new LambdaQueryWrapper<SysRoleMenus>()
                .eq(SysRoleMenus::getRoleId, sysUserRoles.getRoleId()));

        List<String> list = new ArrayList<>();
        for (SysRoleMenus sysRoleMenus1:sysRoleMenus)
        {
            list.add(sysRoleMenus1.getMenuId());
        }

        List<SysMenus> sysMenus = sysMenusService.getBaseMapper().selectBatchIds(list).stream().sorted(Comparator.comparing(SysMenus::getId)).collect(Collectors.toList());

        return  Result.success(sysMenus);
    }

    @RequestMapping("/adduser")
    public Result adduser(SysUser sysUser, String roleId)
    {

        SysUserRoles sysUserRoles = new SysUserRoles();

        sysUser.setFPassword(EncryptAndDecryptUtils.base64Encrypt(sysUser.getFPassword()));

        boolean b = sysUserService.saveOrUpdate(sysUser);

        sysUserRoles.setUserId(sysUser.getId());

        sysUserRoles.setRoleId(roleId);

        sysUserRolesService.getBaseMapper().insert(sysUserRoles);
        return Result.success(b);
    }


    /**
     * 返回所有用户以及用户对应的角色
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectUser()
    {
        List<SysUser> sysUserList = sysUserService.list();


        for (SysUser sysUser:sysUserList)
        {
            SysUserRoles sysUserRoles = sysUserRolesService.getBaseMapper()
                    .selectOne(new LambdaQueryWrapper<SysUserRoles>()
                            .eq(SysUserRoles::getUserId, sysUser.getId()));

            SysRoles sysRoles = sysRolesService.getBaseMapper()
                    .selectOne(new LambdaQueryWrapper<SysRoles>()
                            .eq(SysRoles::getId, sysUserRoles.getRoleId()));

            sysUser.setSysRoles(sysRoles);
        }

        return Result.success(sysUserList);
    }

    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public Result update(SysUser sysUser, String roleId)
    {

        boolean b = sysUserService.saveOrUpdate(sysUser);

        List<SysUserRoles> sysUserRolesList = sysUserRolesService.list(new LambdaQueryWrapper<SysUserRoles>()
                .eq(SysUserRoles::getUserId, sysUser.getId()));

        SysUserRoles sysUserRoles = new SysUserRoles();
        sysUserRoles.setId(sysUserRolesList.get(0).getId());
        sysUserRoles.setRoleId(roleId);

        sysUserRolesService.saveOrUpdate(sysUserRoles);

        return Result.success();
    }

    @RequestMapping(value = "/deletebyid",method = {RequestMethod.POST})
    public Result deletebyid(String id)
    {

        sysUserService.removeById(id);
        sysUserRolesService.remove(new LambdaQueryWrapper<SysUserRoles>().eq(SysUserRoles::getUserId , id));

        return Result.success();
    }
}

