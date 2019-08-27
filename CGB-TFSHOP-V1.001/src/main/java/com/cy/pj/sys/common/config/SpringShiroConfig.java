package com.cy.pj.sys.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
@Configuration
public class SpringShiroConfig {
	@Bean
	public SecurityManager newSecurityManager(@Autowired Realm realm) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		return sManager;
	}
	
	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(@Autowired SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean=new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		sfBean.setLoginUrl("/doHomeUI");
		LinkedHashMap<String,String> map = new LinkedHashMap<>();
		map.put("/AmazeUI-2.4.2/**","anon"); 
		map.put("/basic/**","anon");
		map.put("/css/**","anon"); 
		map.put("/images/**","anon");
		map.put("/js/**","anon");
		map.put("/doLoginUI","anon");
		map.put("/doCenterUI","anon");
		map.put("/doPayUI","anon");
		map.put("/doShopCartUI", "anon");
		map.put("/user/doLogin","anon");
		map.put("/**","authc");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	} 

}
