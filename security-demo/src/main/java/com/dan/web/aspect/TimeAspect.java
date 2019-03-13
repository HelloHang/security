package com.dan.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by dangao on 3/5/2019.
 */

@Aspect
@Component
public class TimeAspect
{
	@Around("execution(* com.dan.web.controller.UserController.*(..))")
	public Object handlerUserControllerMethod(ProceedingJoinPoint point) throws Throwable
	{
//		System.out.println("time aspect start");
		for(Object arg : point.getArgs())
		{
//			System.out.println("arg is "+ arg);
		}
		long start = new Date().getTime();
		Object object = point.proceed();
//		System.out.println("耗时：" + (new Date().getTime() - start));
//		System.out.println("time aspect end");
		return object;
	}

}
