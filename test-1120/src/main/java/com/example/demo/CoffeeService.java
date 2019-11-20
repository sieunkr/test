package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    Flux<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    Mono<Coffee> getCoffeeByName(String name) {
        return coffeeRepository.findCoffeeByName(name);
    }
}