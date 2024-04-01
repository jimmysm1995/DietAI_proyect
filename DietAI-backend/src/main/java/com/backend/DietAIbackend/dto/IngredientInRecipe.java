package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Ingredient;

public record IngredientInRecipe(Ingredient ingredient, double quantity ) {
}
