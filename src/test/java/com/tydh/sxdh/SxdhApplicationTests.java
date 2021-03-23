package com.tydh.sxdh;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils;
import com.tydh.sxdh.entity.SysOrganize;
import com.tydh.sxdh.entity.SysUser;
import com.tydh.sxdh.mapper.SysOrganizeMapper;
import com.tydh.sxdh.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils.base64Encrypt;

@SpringBootTest
class SxdhApplicationTests {
	@Autowired
	private SysOrganizeMapper sysOrganizeMapper;

	@Test
	public void findUserbyLogin()
	{

		Page<SysOrganize> page = new Page(0,2);
		System.out.println(sysOrganizeMapper.selectPageVo(page,null));
	}


}
