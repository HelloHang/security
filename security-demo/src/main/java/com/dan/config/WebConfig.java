package com.dan.config;

import com.dan.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created by dangao on 3/5/2019.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer
{
	@Autowired
	private TimeInterceptor timeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(timeInterceptor);
	}
//
//	@Override
//	public void configureAsyncSupport(AsyncSupportConfigurer configurer)
//	{
//		configurer.registerCallableInterceptors();
//		configurer.registerDeferredResultInterceptors();
//		configurer.setDefaultTimeout();
//		configurer.setTaskExecutor();
//	}
}
