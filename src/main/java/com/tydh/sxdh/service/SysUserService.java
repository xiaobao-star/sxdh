package com.tydh.sxdh.service;

import com.tydh.sxdh.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzb
 * @since 2021-03-11
 */
public interface SysUserService extends IService<SysUser> {

    public List<SysUser> findUserByLogin(String username, String password);
}
