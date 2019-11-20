package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coffees")
@AllArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping
    Flux<Coffee> all() {
        return coffeeService.getAllCoffees();
    }

    @GetMapping("/{name}")
    Mono<Coffee> byName(@PathVariable String name) {
        return coffeeService.getCoffeeByName(name);
    }

    //RouterFunction 으로 개선 가능
}