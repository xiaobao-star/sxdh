package com.tydh.sxdh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils;
import com.tydh.sxdh.entity.SysUser;
import com.tydh.sxdh.mapper.SysUserMapper;
import com.tydh.sxdh.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzb
 * @since 2021-03-11
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    public SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findUserByLogin(String username, String password)
    {
        List<SysUser> sysUserList = sysUserMapper.selectList(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getFUsername, username)
                .eq(SysUser::getFPassword, EncryptAndDecryptUtils.base64Encrypt(password)));

        return sysUserList;
    }

}
