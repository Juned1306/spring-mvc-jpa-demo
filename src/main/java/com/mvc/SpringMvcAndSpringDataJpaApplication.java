package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mvc", "com.mvc.controller","com.mvc.entity","com.mvc.repository","com.mvc.service","com.mvc.configuration"
		,"com.mvc.interceptor", "com.mvc.exception"})
public class SpringMvcAndSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcAndSpringDataJpaApplication.class, args);
	}

}
