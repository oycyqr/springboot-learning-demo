package com.oycbest.springbootelasticsearch.config;

import org.springframework.boot.SpringBootConfiguration;

import javax.annotation.PostConstruct;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:36
 * @Description: ES配置类
 */
@SpringBootConfiguration
public class ElasticSearchConfig {
	@PostConstruct
	void init() {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
	}
}
