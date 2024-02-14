package com.dietai.dietai.dto;

import lombok.Data;

@Data
public class IngredientRecipeDto {

    private IngredientDto ingredient;

    private RecipeDto recipe;
}
