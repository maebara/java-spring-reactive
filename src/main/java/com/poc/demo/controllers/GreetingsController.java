package com.poc.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class GreetingsController {

    @GetMapping("/greetings")
    public Mono<String> sayHello() {
        return Mono.just("hello");
    }

    @GetMapping("/lorem")
    public Flux<String> lorem() {
        return Flux.fromIterable(List.of("lorem", "ipsum", "test"));
    }

}
