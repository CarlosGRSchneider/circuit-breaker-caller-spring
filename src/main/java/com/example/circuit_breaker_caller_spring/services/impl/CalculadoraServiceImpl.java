package com.example.circuit_breaker_caller_spring.services.impl;

import com.example.circuit_breaker_caller_spring.clients.CalculadoraClient;
import com.example.circuit_breaker_caller_spring.exceptions.FallbackException;
import com.example.circuit_breaker_caller_spring.requests.CalculadoraRequest;
import com.example.circuit_breaker_caller_spring.services.CalculadoraService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    @Autowired
    private CalculadoraClient client;

    @Override
//    @CircuitBreaker(name = "circuitoCalculadora")
    @CircuitBreaker(name = "circuitoCalculadora", fallbackMethod = "fallbackProcessaCalculadoraException")
    public String processaCalculadoraRequest(CalculadoraRequest request) {

        String responsePadrao = "Realizando calculos complexos. \n\n Response vindo do microsserviço: ";
        String resultadoDoCalculo = client.realizaCalculosComplexos(request);

        return responsePadrao.concat(resultadoDoCalculo);
    }

    private String fallbackProcessaCalculadoraException(Throwable cause) {

        throw new FallbackException("Desculpe estamos em obras no momento, por favor tente mais tarde.", cause);
    }
}
