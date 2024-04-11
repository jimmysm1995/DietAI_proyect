package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class IngredientSummary {

    private Long id;

    private String name;

    private double totalQuantity;

    public IngredientSummary(Long id, String name, Double totalQuantity) {
        this.id = id;
        this.name = name;
        this.totalQuantity = totalQuantity;
    }

}
