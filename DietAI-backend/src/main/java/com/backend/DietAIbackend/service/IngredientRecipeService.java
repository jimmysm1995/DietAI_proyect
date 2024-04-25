package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.IngredientRecipe;
import java.util.List;

public interface IngredientRecipeService {

    IngredientRecipe save(IngredientRecipe ingredientRecipe);

    List<IngredientRecipe> findAll();
}
