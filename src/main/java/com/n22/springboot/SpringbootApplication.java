package com.n22.springboot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
