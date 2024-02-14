package com.dietai.dietai.dto;

import lombok.Data;

import java.util.List;

@Data
public class IngredientDto {

    private String name;

    private double protein; // Proteins in grams

    private double carbohydrates; // Carbohydrates in grams

    private double fats; // Fats in grams

    private List<IngredientRecipeDto> ingredientRecipe;
}
