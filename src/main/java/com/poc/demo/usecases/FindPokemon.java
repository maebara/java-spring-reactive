package com.poc.demo.usecases;

import com.poc.demo.controllers.FindTypeRequest;
import com.poc.demo.exceptions.PokemonNotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class FindPokemon {

    public Mono<PokemonResponse> find(FindRequest findRequest) {
        String pokemonName = findRequest.getPokemonName();

        if ("charizard".equals(pokemonName)) {
            return Mono.just(new PokemonResponse("006", "Charizard", "Fire"));
        }

        return Mono.error(new PokemonNotFoundException(String.format("pokemon %s not found", pokemonName)));
    }

    public Flux<PokemonResponse> findByType(FindTypeRequest findRequest) {
        String pokemonType = findRequest.getPokemonType();
        List<PokemonResponse> pokemons = List.of(new PokemonResponse("006", "Charizard", "Fire"),
                new PokemonResponse("005", "Charmeleon", "Fire"),
                new PokemonResponse("004", "Charmander", "Fire"));

        if ("fire".equals(pokemonType)) {
            return Flux.fromIterable(pokemons);
        }
        return Flux.empty();
    }
}
