package com.dan.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 * Created by dangao on 3/5/2019.
 */
//@Component
public class TimeFilter implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
//		System.out.println("Time Filter Init");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
		  throws IOException, ServletException
	{
//		System.out.println("Time Filter Start");
		long start = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
		filterChain.doFilter(servletRequest, servletResponse);
		long end = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
//		System.out.println("Time:" + (end- start));
//		System.out.println("Time Filter End");
	}

	@Override
	public void destroy()
	{
		System.out.println("Time Filter Destroy");
	}
}
