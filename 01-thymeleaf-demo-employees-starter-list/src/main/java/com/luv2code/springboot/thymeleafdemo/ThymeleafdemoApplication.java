package com.luv2code.springboot.thymeleafdemo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafdemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ThymeleafdemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/"));
		app.run(args);
		//SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

}
