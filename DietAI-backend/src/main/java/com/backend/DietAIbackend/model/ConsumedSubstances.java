package com.backend.DietAIbackend.model;

public enum ConsumedSubstances {
    ALCOHOL("Alcohol"),
    TABACO("Tabaco"),
    BOTH("Ambos"),
    NONE("Ninguna");

    private final String name;

    ConsumedSubstances(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
