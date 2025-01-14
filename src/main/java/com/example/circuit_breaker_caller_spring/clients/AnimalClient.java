package com.example.circuit_breaker_caller_spring.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AnimalClient", url = "${base.service.url}")
public interface AnimalClient {

    @GetMapping("/animais")
    String getCombinacaoAnimal();
}
