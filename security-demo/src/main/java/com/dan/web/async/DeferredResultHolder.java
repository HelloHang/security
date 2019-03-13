package com.dan.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by dangao on 3/7/2019.
 */

@Component
public class DeferredResultHolder
{
	private Map<String, DeferredResult<String>> map = new HashMap<>();

	public Map<String, DeferredResult<String>> getMap()
	{
		return map;
	}

	public void setMap(Map<String, DeferredResult<String>> map)
	{
		this.map = map;
	}
}
