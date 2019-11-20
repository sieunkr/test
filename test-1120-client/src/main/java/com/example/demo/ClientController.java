package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/coffees")
@AllArgsConstructor
public class ClientController {

    private final WebClient webClient;

    private final RSocketRequester rSocketRequester;

    /*
    @GetMapping
    Flux<Coffee> allCoffeesFromService() {
        return webClient.get()
                .uri("/coffees")
                .retrieve()
                .bodyToFlux(Coffee.class);

        //return requester.route("coffees").retrieveFlux(Coffee.class);
    }
    */

    @GetMapping
    Flux<Coffee> allCoffeesFromService() {

        return rSocketRequester.route("coffees").retrieveFlux(Coffee.class);
    }
    
}
