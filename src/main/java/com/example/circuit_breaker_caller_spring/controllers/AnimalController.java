package com.example.circuit_breaker_caller_spring.controllers;

import com.example.circuit_breaker_caller_spring.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamada-animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<String> processaChamadaAnimal() {

        String response = animalService.processaAnimalRequest();
        return ResponseEntity.ok().body(response);
    }
}
