package com.poc.demo.usecases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonResponse {
    private String id;
    private String name;
    private String type;
}
