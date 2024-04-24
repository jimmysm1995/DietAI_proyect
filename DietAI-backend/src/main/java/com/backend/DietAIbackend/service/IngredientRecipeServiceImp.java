package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.repository.IngredientRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientRecipeServiceImp implements IngredientRecipeService {

    @Autowired
    IngredientRecipeRepository ingredientRecipeRepository;

    public IngredientRecipe save(IngredientRecipe ingredientRecipe){
        return ingredientRecipeRepository.save(ingredientRecipe);
    }

}
