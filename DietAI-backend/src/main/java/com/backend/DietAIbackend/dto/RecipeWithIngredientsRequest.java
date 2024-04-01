package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeWithIngredientsRequest {
    private RecipeDto recipeDto;
    private List<IngredientInRecipe> ingredientInRecipeList;
}
