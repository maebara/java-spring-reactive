package com.poc.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindTypeRequest {
    private String pokemonType;
}
