package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeWithIngredientsRequest {
    private RecipeDto recipe;
    private List<IngredientInRecipe> ingredientInRecipe;
}
