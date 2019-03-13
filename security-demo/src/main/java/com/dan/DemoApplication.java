package com.dan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by dangao on 3/4/2019.
 */

@SpringBootApplication
@RestController
@EnableSwagger2
public class DemoApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class);
	}

	@GetMapping("/hello")
	public String hello()
	{
		return "hello world!";
	}
}
