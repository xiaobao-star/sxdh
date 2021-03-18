package com.tydh.sxdh;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils;
import com.tydh.sxdh.entity.SysUser;
import com.tydh.sxdh.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils.base64Encrypt;

@SpringBootTest
class SxdhApplicationTests {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Test
	public void findUserbyLogin() {
		System.out.println(findUserbyLogin("admin","123456").toString());
	}

	public List<SysUser> findUserbyLogin(String username, String password)
	{
		List<SysUser> sysUserList = sysUserMapper.selectList(new LambdaQueryWrapper<SysUser>()
				.eq(SysUser::getFUsername, username)
				.eq(SysUser::getFPassword, base64Encrypt(password)));

		return sysUserList;
	}

}
