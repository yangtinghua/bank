package com.yth.rpc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;

@Configuration
public class MotanConfig {

	@Bean
	@ConfigurationProperties(prefix = "motan.annotation")
	public AnnotationBean motanAnnotationBean() {
		AnnotationBean motanAnnotationBean = new AnnotationBean();
		return motanAnnotationBean;
	}

	@Bean(name = "motan")
	@ConfigurationProperties(prefix = "motan.protocol")
	public ProtocolConfigBean protocolConfig() {
		ProtocolConfigBean config = new ProtocolConfigBean();
		return config;
	}

	@Bean(name = "motanRegistryConfig")
	@ConfigurationProperties(prefix = "motan.registry")
	public RegistryConfigBean registryConfig() {
		RegistryConfigBean config = new RegistryConfigBean();
		return config;
	}
}
