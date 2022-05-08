package com.poc.demo.usecases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindRequest {
    private String pokemonName;
}
