package com.dan.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * Created by dangao on 3/5/2019.
 */
@Component
public class TimeInterceptor implements HandlerInterceptor
{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
//		System.out.println("preHandle");
		request.setAttribute("startTime", new Date().getTime());
//		System.out.println((HandlerMethod)handler);
//		System.out.println("preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		  ModelAndView modelAndView) throws Exception
	{
//		System.out.println("postHandle");
		Long startTime = (Long) request.getAttribute("startTime");
//		System.out.println("耗时：" + (new Date().getTime() - startTime));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		  throws Exception
	{
		//在exceptionHandler之后处理，如果在handler中处理了exception,这里的exception将会是null
//		System.out.println("afterCompletion");
		Long startTime = (Long) request.getAttribute("startTime");
//		System.out.println("耗时：" + (new Date().getTime() - startTime));
//		System.out.println("ex is：" + ex);
	}
}
