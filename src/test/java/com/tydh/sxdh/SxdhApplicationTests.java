package com.tydh.sxdh;

import com.tydh.sxdh.entity.SysUser;
import com.tydh.sxdh.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SxdhApplicationTests {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Test
	public void testSelect() {
		System.out.println("----- selectAll method test ------");
		SysUser sysUsers = sysUserMapper.selectById(1);

		System.out.println(sysUsers);


	}

}
