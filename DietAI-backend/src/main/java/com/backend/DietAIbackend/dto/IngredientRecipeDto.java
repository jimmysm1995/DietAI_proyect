package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class IngredientRecipeDto {

    private Long id;

    private Integer quantity;

    private IngredientDto ingredient;

    private RecipeDto recipe;
}
