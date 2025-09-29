package com.tech.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${app.name}")
	private String name;
	
	@Value("${app.port}")
	private String port;

	public String getName() {
		return name;
	}

	public String getPort() {
		return port;
	}
	
}
