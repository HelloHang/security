package com.dan.wiremock;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by dangao on 3/7/2019.
 */
public class MockServer
{
	public static void main(String[] args) throws IOException
	{
		configureFor(10003);
		removeAllMappings();

		mock("/order/1", "01");
	}

	private static void mock(String url, String file) throws IOException
	{
		ClassPathResource classPathResource = new ClassPathResource("mock/response/" + file + ".txt");
		String content = StringUtils.join(FileUtils.readLines(classPathResource.getFile(), "UTF-8").toArray(),"\n");
		stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withStatus(200).withBody(content)));
	}
}
