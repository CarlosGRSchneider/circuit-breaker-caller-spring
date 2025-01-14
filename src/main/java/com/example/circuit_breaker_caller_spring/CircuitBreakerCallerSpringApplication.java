package com.example.circuit_breaker_caller_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CircuitBreakerCallerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerCallerSpringApplication.class, args);
	}

}
