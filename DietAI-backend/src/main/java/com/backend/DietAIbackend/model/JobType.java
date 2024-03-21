package com.backend.DietAIbackend.model;

public enum JobType {
    SEDENTARY("Sedentario"),
    MEDIUM_ACTIVE("Medio activo"),
    ACTIVE("Activo"),
    VERY_ACTIVE("Muy activo");

    private final String name;

    JobType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
