package com.example.circuit_breaker_caller_spring.services;

import com.example.circuit_breaker_caller_spring.requests.CalculadoraRequest;

public interface CalculadoraService {

    String processaCalculadoraRequest(CalculadoraRequest request);
}
