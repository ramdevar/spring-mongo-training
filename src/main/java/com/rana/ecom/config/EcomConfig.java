package com.rana.ecom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Rana
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.rana.ecom.config.*" })
@PropertySource("classpath:ecom.properties")

public class EcomConfig {
	
	

	@Value("${db.host}")
	private String DB_HOST;
	
	@Value("${db.name}")
	private String DB_NAME;
	
	@Value("${db.port}")
	private int DB_PORT;
	
	@Value("${db.user}")
	private String user;
	
	@Value("${db.password}")
	private String password;
	
	

	public String getDB_HOST() {
		return DB_HOST;
	}

	public String getDB_NAME() {
		return DB_NAME;
	}
	
	public int getDB_PORT() {
		return DB_PORT;
	}

	

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	
}
