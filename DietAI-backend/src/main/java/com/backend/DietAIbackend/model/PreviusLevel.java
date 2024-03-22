package com.backend.DietAIbackend.model;

public enum PreviusLevel {
    NEVER("No entreno nunca"),
    SOME_TIMES("Suelo entrenar algunos dias"),
    DIARY("Suelo entrenar Diariamente");

    private final String name;

    PreviusLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
