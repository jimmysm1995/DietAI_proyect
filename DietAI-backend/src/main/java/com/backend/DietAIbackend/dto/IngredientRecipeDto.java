package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class IngredientRecipeDto {

    private Long idIngredientRecipe;

    private Integer quantity;

    private IngredientDto ingredient;

    private RecipeDto recipe;
}
