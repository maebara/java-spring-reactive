package com.poc.demo.controllers;

import com.poc.demo.exceptions.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class PokemonExceptionHandler {

    @ExceptionHandler(PokemonNotFoundException.class)
    public Mono<ResponseEntity<ErrorResponse>> handle(PokemonNotFoundException exception) {
        return Mono.just(new ResponseEntity<>(new ErrorResponse(exception.getStackTrace(), exception.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND));
    }
}
