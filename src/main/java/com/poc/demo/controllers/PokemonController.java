package com.poc.demo.controllers;

import com.poc.demo.usecases.FindPokemon;
import com.poc.demo.usecases.FindRequest;
import com.poc.demo.usecases.PokemonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/")
public class PokemonController {
    @Autowired
    private FindPokemon findPokemon;

    @GetMapping("/pokemon/find/{pokemon_name}")
    public Mono<ResponseEntity<Mono<PokemonResponse>>> findPokemon(@PathVariable("pokemon_name") String pokemonName) {
        FindRequest findRequest = new FindRequest(pokemonName);
        return Mono.just(ResponseEntity.ok(findPokemon.find(findRequest)));
    }

    @GetMapping("/pokemon/find/type/{pokemon_type}")
    public Mono<ResponseEntity<Flux<PokemonResponse>>> findByTypePokemon(@PathVariable("pokemon_type") String pokemonType) {
        FindTypeRequest findRequest = new FindTypeRequest(pokemonType);
        return Mono.just(ResponseEntity.ok(findPokemon.findByType(findRequest)));
    }
}
