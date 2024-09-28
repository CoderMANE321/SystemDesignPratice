package com.example.demo;

import RateLimiter.Client;
import RateLimiter.Gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		boolean run = true;
		Gateway gateway = new Gateway();
		Client client = new Client();
		Runnable task = () -> {
			client.sendRequest();
			gateway.handleRequest("GET");
		};
		while (run){
			new Thread(task).start();
		}
	}


	@GetMapping("/hello")
	public String hello() {
		return "Hello, Spring Boot!";
	}

	@GetMapping("/test")
	public String test() {
		return "interface up";
	}
}
