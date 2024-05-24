package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.repository.IngredientRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientRecipeServiceImp implements IngredientRecipeService {

    @Autowired
    IngredientRecipeRepository ingredientRecipeRepository;

    public IngredientRecipe save(IngredientRecipe ingredientRecipe){
        return ingredientRecipeRepository.save(ingredientRecipe);
    }

    @Override
    public List<IngredientRecipe> findAll() {
        return ingredientRecipeRepository.findAll();
    }

    @Override
    public List<IngredientRecipe> findByIngredientIdIngredient(Long idIngredient) {
        return ingredientRecipeRepository.findByIngredientIdIngredient(idIngredient);
    }

    @Override
    public void delete(IngredientRecipe ingredientRecipe) {
        ingredientRecipeRepository.delete(ingredientRecipe);
    }
}
