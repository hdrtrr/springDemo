package com.example.springDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SpringDemoApplication {

	@RequestMapping("/")
    @ResponseBody
	public String index() {
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
