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
	private static Gateway gateway = new Gateway();
	public static boolean run = true;
	public static boolean requestHandled;
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);
		Client client = new Client();
		Runnable task = () -> {
			requestHandled = gateway.handleRequest("GET");
			client.sendRequest();
		};
		while (run) {
			new Thread(task).start();
			Thread.sleep(100);
		}
	}

	@GetMapping("/hello")
	public String hello() {
		if (requestHandled) {
			return "Hello, Spring Boot!";
		} else {
			return "Sorry, wait a second...";
		}
	}
}
