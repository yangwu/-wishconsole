package com.wishconsole.flymagic.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DBServer {

	@Value("${jdbc.driver-class-name}")
	private String driveClass;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.maxActive}")
	private int maxActive;
	@Value("${jdbc.maxWait}")
	private long maxWait;
	@Value("${jdbc.initialSize}")
	private int initialSize;
	@Value("${jdbc.minIdle}")
	private int minIdle;

	@Bean
	public DataSource dataSource() {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(driveClass);
		dds.setUrl(url);
		dds.setUsername(username);
		dds.setPassword(password);
		dds.setMaxActive(maxActive);
		dds.setMaxWait(maxWait);
		dds.setInitialSize(initialSize);
		dds.setMinIdle(minIdle);
		dds.setValidationQuery("SELECT 1");
		dds.setTestOnBorrow(true);
		return dds;
	}
}
