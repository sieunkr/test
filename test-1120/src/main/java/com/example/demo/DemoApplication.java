package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

    private final CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init(){

        coffeeRepository.deleteAll().thenMany(
                Flux.just("americano", "latte", "mocha")
                        .map(Coffee::new)
                        .flatMap(coffeeRepository::save))
                .thenMany(coffeeRepository.findAll())
                .subscribe(System.out::println);
    }
}