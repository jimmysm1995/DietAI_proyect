package com.backend.DietAIbackend.model;

public enum Muscle {
    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    LEGS("Legs"),
    ABS("Abdominals");

    private final String muscleName;

    Muscle(String muscleName) {
        this.muscleName = muscleName;
    }

    public String getMuscleName() {
        return muscleName;
    }
}
