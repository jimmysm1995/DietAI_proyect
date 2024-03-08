package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class IngredientDto {

    private Long idIngredient;

    private String name;

    private double protein; // Proteins in grams

    private double carbohydrates; // Carbohydrates in grams

    private double fats; // Fats in grams

    private Integer calories;

    private List<IngredientRecipeDto> ingredientRecipe;
}
