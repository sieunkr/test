package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@AllArgsConstructor
public class RSController {

    private final CoffeeService coffeeService;

    @MessageMapping("coffees")
    Flux<Coffee> all() {
        return coffeeService.getAllCoffees();
    }



}