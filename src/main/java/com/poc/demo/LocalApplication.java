package com.poc.demo;

import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

public class LocalApplication {
    public Flux<Point> getPoints() {
        return Flux.fromIterable(List.of(new Point(1, 2))).log();
    }

    public static void main(String[] args) {
        LocalApplication app = new LocalApplication();
        app.getPoints().subscribe(System.out::println);
    }
}
