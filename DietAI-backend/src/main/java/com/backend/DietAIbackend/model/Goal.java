package com.backend.DietAIbackend.model;

public enum Goal {
    LOSE_WEIGHT("Perder peso"),
    GAIN_WEIGHT("Ganar peso"),
    DEFINE("Definir");

    private final String name;

    Goal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
