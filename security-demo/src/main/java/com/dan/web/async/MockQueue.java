package com.dan.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by dangao on 3/7/2019.
 */

@Component
public class MockQueue
{
	private Logger LOG = LoggerFactory.getLogger(MockQueue.class);
	private String placeOrder;

	private String completeOrder;

	public String getPlaceOrder()
	{
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws InterruptedException
	{
		new Thread(() ->{

			LOG.info("接到订单："+placeOrder);

			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			this.completeOrder = placeOrder;

			LOG.info("完成订单：" + placeOrder);
		}).start();
	}

	public String getCompleteOrder()
	{
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder)
	{
		this.completeOrder = completeOrder;
	}
}
