package com.tydh.sxdh;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils;
import com.tydh.sxdh.entity.*;
import com.tydh.sxdh.mapper.SysOrganizeMapper;
import com.tydh.sxdh.mapper.SysUserMapper;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.*;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils.base64Encrypt;

@SpringBootTest
class SxdhApplicationTests {

	@Autowired
	private SysMenusService sysMenusService;

	@Test
	public void findUserbyLogin()
	{
		WorkShop().forEach(str -> System.out.println(str));
	}


	public List<SysMenus> WorkShop()
	{
		List<SysMenus> sysMenus1 = sysMenusService.getBaseMapper().selectList(new LambdaQueryWrapper<SysMenus>()
				.orderByAsc(SysMenus::getId));

		return sysMenus1;
	}
}
