package com.backend.DietAIbackend.model;

public enum Plan {
    BASICO("Basico"),
    PREMIUM("Premium");

    private final String name;

    Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
