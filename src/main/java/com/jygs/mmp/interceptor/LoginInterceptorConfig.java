package com.jygs.mmp.interceptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Value("${user.addPath}")
	private List<String> addPath;
	
	@Value("${user.excludePath}")
	private List<String> excludePath;
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns(addPath)
		.excludePathPatterns(excludePath);
		
	}
}
