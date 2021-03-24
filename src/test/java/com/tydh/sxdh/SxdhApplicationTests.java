package com.tydh.sxdh;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils;
import com.tydh.sxdh.entity.SysOrganize;
import com.tydh.sxdh.entity.SysUser;
import com.tydh.sxdh.entity.SysWorkshop;
import com.tydh.sxdh.mapper.SysOrganizeMapper;
import com.tydh.sxdh.mapper.SysUserMapper;
import com.tydh.sxdh.result.Result;
import com.tydh.sxdh.service.SysOrganizeService;
import com.tydh.sxdh.service.SysWorkshopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.tydh.sxdh.JUtils.encrypt.EncryptAndDecryptUtils.base64Encrypt;

@SpringBootTest
class SxdhApplicationTests {
	@Autowired
	private SysWorkshopService sysWorkshopService;

	@Autowired
	private SysOrganizeService sysOrganizeService;
	@Test
	public void findUserbyLogin()
	{
		selectWorkShop().forEach(str -> System.out.println(str));
	}

	public List<SysWorkshop> selectWorkShop()
	{
		List<SysWorkshop> sysWorkshopList = sysWorkshopService.list();

		for (SysWorkshop s:sysWorkshopList)
		{
			s.setSysOrganize(sysOrganizeService.getById(s.getOrgnizeId()));
		}
		return sysWorkshopList;
	}
}
