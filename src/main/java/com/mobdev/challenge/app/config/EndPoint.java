package com.mobdev.challenge.app.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:endpoint.properties")
@ConfigurationProperties(prefix = "endpoint.url")

public class EndPoint {
	
	@Getter @Setter
	private String characterById;

}
