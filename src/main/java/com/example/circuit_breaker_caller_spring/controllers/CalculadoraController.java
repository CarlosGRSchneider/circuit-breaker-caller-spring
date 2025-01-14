package com.example.circuit_breaker_caller_spring.controllers;

import com.example.circuit_breaker_caller_spring.requests.CalculadoraRequest;
import com.example.circuit_breaker_caller_spring.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora-complexa")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping
    public ResponseEntity<String> processaCalulosComplexos(@RequestBody CalculadoraRequest request) {

        String response = calculadoraService.processaCalculadoraRequest(request);
        return ResponseEntity.ok().body(response);
    }
}
