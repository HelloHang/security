package com.dan.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;


/**
 * Created by dangao on 3/7/2019.
 * 异步处理rest服务，提高系统吞吐量
 */
@RestController
public class AsyncController
{
	private Logger LOG = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private MockQueue mockQueue;

	@Autowired
	private DeferredResultHolder deferredResultHolder;

	@RequestMapping("/order1")
	public Callable<String> order1() throws InterruptedException
	{
		LOG.info("主线程开始");

		Callable<String> result = new Callable<String>()
		{

			@Override
			public String call() throws Exception
			{
				LOG.info("副线程开始");
				Thread.sleep(2000);
				LOG.info("副线程结束");
				return "success";
			}
		};
		LOG.info("主线程结束");
		return result;
	}

	@RequestMapping("/order2")
	public DeferredResult<String> order2() throws InterruptedException
	{
		LOG.info("主线程开始");

		String orderNumber = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumber);

		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber, result);

		LOG.info("主线程结束");
		return result;
	}
}
