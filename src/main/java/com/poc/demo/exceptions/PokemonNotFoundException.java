package com.poc.demo.exceptions;

public class PokemonNotFoundException extends Exception {
    public PokemonNotFoundException(String msg) {
        super(msg);
    }
}
