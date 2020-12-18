package com.n22.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// 注解开启缓存功能
//@EnableCaching
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		// 关闭banner展示
		/*
		SpringApplication app= new SpringApplication(SpringbootApplication.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
		*/
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
