package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.model.Recipe;

import java.util.List;

public interface RecipeService extends ICrudService<Recipe, Long>{
    Recipe save(Recipe receta, List<IngredientInRecipe> ingredientInRecipeList);
}
