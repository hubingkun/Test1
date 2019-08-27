package com.cy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired 
	SysUserDao sys;
	@Test
	public void contextLoads() {
	}
	@Test
	public void testfind() {
		SysUser user = sys.findObjectById(1);
		System.out.println(user.toString());
	}
	@Test
	public void testupdate() {
		SysUser user = new SysUser();
		user.setName("aaa");
		user.setEmail("2514@qq.com");
		user.setMobile("13524785855");
		user.setPassword("123456789");
		int row = sys.updateUser(user);
		System.out.println(row);
	}
	
}
