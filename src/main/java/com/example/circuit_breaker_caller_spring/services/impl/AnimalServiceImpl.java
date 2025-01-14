package com.example.circuit_breaker_caller_spring.services.impl;

import com.example.circuit_breaker_caller_spring.clients.AnimalClient;
import com.example.circuit_breaker_caller_spring.exceptions.FallbackException;
import com.example.circuit_breaker_caller_spring.services.AnimalService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.circuit_breaker_caller_spring.caches.AnimalCache.cacheiaResultado;
import static com.example.circuit_breaker_caller_spring.caches.AnimalCache.getAnimalCache;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalClient client;

    @Override
//    @CircuitBreaker(name = "circuitoAnimal")
//    @CircuitBreaker(name = "circuitoAnimal", fallbackMethod = "fallbackProcessaAnimalException")
    @CircuitBreaker(name = "circuitoAnimal", fallbackMethod = "fallbackProcessaAnimalCache")

    public String processaAnimalRequest() {

        String responsePadrao = "Iniciando processamento de request animal. \n\n Response vindo do microsserviço: ";
        String animalSelecionado = client.getCombinacaoAnimal();

        cacheiaResultado(animalSelecionado);

        return responsePadrao.concat(animalSelecionado);
    }

    private String fallbackProcessaAnimalException(Throwable cause) {

        throw new FallbackException("Desculpe estamos em obras no momento, por favor tente mais tarde.", cause);
    }

    private String fallbackProcessaAnimalCache(Throwable cause) {

        return "Resposta de fallback vindo de cache: " + getAnimalCache();
    }
}
