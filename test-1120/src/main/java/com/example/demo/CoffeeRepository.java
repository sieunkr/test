package com.example.demo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CoffeeRepository extends ReactiveCrudRepository<Coffee, String> {
    Mono<Coffee> findCoffeeByName(String name);
}