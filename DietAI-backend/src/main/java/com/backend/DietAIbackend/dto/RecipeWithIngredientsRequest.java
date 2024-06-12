package com.backend.DietAIbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeWithIngredientsRequest {
    private RecipeDto recipe;
    private List<IngredientInRecipe> ingredientInRecipe;
}
