package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.AllergyDto;
import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.dto.RecipeWithIngredientsRequest;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Recipe;

import java.util.List;

public interface RecipeService extends ICrudService<Recipe, Long>{
    Recipe save(Recipe receta, List<IngredientInRecipe> ingredientInRecipeList, List<Allergy> allergyList);

    RecipeWithIngredientsRequest getRecipeWithIngredients(Long idRecipe);

    List<Allergy> findAllAllergiesInRecipe(Long idRecipe);
}
