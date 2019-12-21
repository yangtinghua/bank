package com.yth.rpc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;

@Configuration
public class MotanClientConfig {

	@Bean(name = "motanClientBasicConfig")
	@ConfigurationProperties(prefix = "motan.client")
	public BasicRefererConfigBean baseRefererConfig() {
		BasicRefererConfigBean config = new BasicRefererConfigBean();
		return config;
	}
}
