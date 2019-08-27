package com.cy.pj.sys.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebFilterConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean newFilterRegistrationBean() {
		FilterRegistrationBean fBean=new FilterRegistrationBean();
		DelegatingFilterProxy filter = new DelegatingFilterProxy("shiroFilterFactory");
		fBean.setFilter(filter);
		fBean.addUrlPatterns("/**");
		return fBean;
	}
}
