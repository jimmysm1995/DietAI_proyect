package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class IngredientRecipeDto {

    private IngredientDto ingredient;

    private RecipeDto recipe;
}
