package com.backend.DietAIbackend.model;

public enum PreviusLevel {
    NEVER("Nunca"),
    SOME_TIMES("A veces"),
    DIARY("Diariamente");

    private final String name;

    PreviusLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
