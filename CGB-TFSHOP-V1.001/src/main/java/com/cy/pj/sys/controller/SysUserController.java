package com.cy.pj.sys.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.sys.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;

@RestController
@RequestMapping("/user/")
public class SysUserController extends HttpServlet{

	private static final long serialVersionUID = -63913194462506311L;
	@Autowired
	private SysUserService sysUserService;
	/*@RequestMapping("doLogin")
	public JsonResult doLogin(boolean isRememberMe,String name,String password) {
		Subject subject = SecurityUtils.getSubject();	
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		 if(isRememberMe) {
				token.setRememberMe(true); 
			 }
		subject.login(token);
		return new JsonResult("login Ok");
		
	}*/
	@RequestMapping("doLogin")
		public JsonResult doLogin(String name,String password,HttpServletResponse response,HttpServletRequest request) {
			HttpSession session=request.getSession();
			if(("logined").equals(session.getAttribute(name))){
				return new JsonResult("login Ok");
			}else {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(name,password);
			subject.login(token);	
			session.setAttribute(name, "logined");
			return new JsonResult("login Ok");
			}
		}
		@RequestMapping("islogin")
		public String islogin(HttpServletRequest request,String name) {
			HttpSession session=request.getSession();
			String s=(String)session.getAttribute(name);
			System.err.println(s);
			if(s!=null&&(("logined").equals(s)==true)) {
				return "ok";
			}else {
				return "no";
			}	
		}
	//用户列表呈现
	@RequestMapping("doUserUI")
	public String doUserUI() {
		return "sys/user";
	}
	//
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		SysUser user = sysUserService.findObjectById(id);
		return new JsonResult(user);
		
	}
	@RequestMapping("doUpdateUser")
	public JsonResult doUpdateUser (SysUser user) {
		sysUserService.updateUser(user);
		return new JsonResult("保存成功");
	}
	@RequestMapping("doFindUserById")
	public JsonResult doFindUserById(Integer id) {
		SysUser user = sysUserService.findUserById(id);
		if(null!=user) {
			
		}
		return new JsonResult(user);
	}
	@RequestMapping("doFindUser")
	public SysUser doFindUesr(String name) {
		SysUser user = sysUserService.finduser(name);
		return user;
	}

}
