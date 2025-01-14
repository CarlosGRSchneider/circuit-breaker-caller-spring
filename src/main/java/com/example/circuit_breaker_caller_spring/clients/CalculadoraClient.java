package com.example.circuit_breaker_caller_spring.clients;

import com.example.circuit_breaker_caller_spring.requests.CalculadoraRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "CalculadoraClient", url = "${base.service.url}")
public interface CalculadoraClient {

    @PostMapping("/calculadora")
    String realizaCalculosComplexos(@RequestBody CalculadoraRequest request);
}
