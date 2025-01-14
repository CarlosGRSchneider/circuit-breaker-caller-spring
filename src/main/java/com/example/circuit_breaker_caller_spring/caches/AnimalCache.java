package com.example.circuit_breaker_caller_spring.caches;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalCache {

    private static Random random = new Random();

    private static List<String> animais;

    static {
        animais = new ArrayList<>();
        animais.add("Fuinha honesta");
    }

    public static void cacheiaResultado(String animal) {
        animais.add(animal);
    }

    public static String getAnimalCache() {
        return animais.get(random.nextInt(animais.size()));
    }
}
