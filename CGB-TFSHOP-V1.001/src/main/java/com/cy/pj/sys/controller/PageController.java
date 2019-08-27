package com.cy.pj.sys.controller;


import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	@RequestMapping("doHomeUI")
	public String doHomeUI() {
		return "home2";
	}
	@RequestMapping("doRegisterUI")
	public String doRegisterUI() {
		return "/home/register";
	}	
	@RequestMapping("doCenterUI")
	public String doCenterUI() {
		Object sysUser =SecurityUtils.getSubject().getPrincipal();
		if(null!=sysUser) {
 		return "/person/index";
		}else {
	    return "login";
		}
		
	}
	@RequestMapping("doInForUI")
	public String doInForUI() {
		return "/person/information";
	}
	@RequestMapping("doShopCartUI")
	public String doShopCartUI() {
		return "/home/shopcart";
	}
	@RequestMapping("doPayUI")
	public String doPayUI() {
		Object sysUser =SecurityUtils.getSubject().getPrincipal();
		if(null!=sysUser) {
 		return "/home/pay";
		}else {
	    return "login";
		}
		
	}
	
}
