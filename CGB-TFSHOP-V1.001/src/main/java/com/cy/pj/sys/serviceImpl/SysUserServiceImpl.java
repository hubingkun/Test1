package com.cy.pj.sys.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
@Autowired 
private SysUserDao sysUserDao;
	@Override
	public SysUser findObjectById(Integer id) {
		if(id==null||id<=0)
			throw new IllegalArgumentException("参数数据不合法");
		SysUser user = sysUserDao.findObjectById(id);
		return user;
	}
	@Override
	public int updateUser(SysUser user) {
		if(user==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(user.getName()))
			throw new IllegalArgumentException("用户名不能为空");
		int rows = sysUserDao.updateUser(user);
		return rows;
	}
	@Override
	public SysUser findUserById(Integer id) {
		SysUser user = sysUserDao.findUserById(id);
		return user;
	}
	@Override
	public SysUser finduser(String name) {
		
		//1.验证参数的合法性
		if(name==null)
			throw new IllegalArgumentException("用户名有误或后台信息丢失");
		//2.根据用户名查询用户信息
		SysUser user = sysUserDao.finduser(name);
		System.out.println(user.toString()+"-----------------------------------");
		if(user==null)
			throw new RuntimeException("用户信息已经不存在");
		
		return user;
	}
	
	
}
