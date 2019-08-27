package com.cy.pj.sys.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;
@Service
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private SysUserDao sysUserDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		String username = upToken.getUsername();
		SysUser user = sysUserDao.findUserByUsername(username);
		if(user==null)
			throw new UnknownAccountException("用户不存在");
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		return info;
	}
}
