package com.wishconsole.flymagic.http;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpUtils {
	@Value("${http.maxTotal}")
	private int maxTotal;
	@Value("${http.defaultMaxPerRoute}")
	private int maxPerRoute;

	@Bean(name = "httpClientConnectionManager")
	public PoolingHttpClientConnectionManager getHttpClientConnectionManager() {
		PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
		// 最大连接数
		httpClientConnectionManager.setMaxTotal(maxTotal);
		// 并发数
		httpClientConnectionManager.setDefaultMaxPerRoute(maxPerRoute);
		return httpClientConnectionManager;
	}
}
