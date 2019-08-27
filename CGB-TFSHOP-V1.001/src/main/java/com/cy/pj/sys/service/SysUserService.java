package com.cy.pj.sys.service;
import com.cy.pj.sys.entity.SysUser;

public interface SysUserService {
	SysUser findObjectById(Integer id);
	
	int updateUser(SysUser user); 
	
	
	
	SysUser findUserById (Integer id); 
	
	
	SysUser finduser(String name);

}
