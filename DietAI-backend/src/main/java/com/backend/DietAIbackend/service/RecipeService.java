package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.ExercisesInTraining;
import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.model.TrainingExercise;
import com.backend.DietAIbackend.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recetaRepository;

    @Autowired
    IngredientRecipeService ingredientRecipeService;

    @Transactional
    public Recipe save(Recipe receta, List<IngredientInRecipe> ingredientInRecipeList) {

        Recipe recipe = recetaRepository.save(receta);

        for (IngredientInRecipe ingredientInRecipe : ingredientInRecipeList
        ) {
            if (ingredientInRecipe.ingredient() != null){
                IngredientRecipe ingredientRecipe = new IngredientRecipe();
                ingredientRecipe.setRecipe(recipe);
                ingredientRecipe.setQuantity(ingredientInRecipe.quantity());
                ingredientRecipe.setIngredient(ingredientInRecipe.ingredient());
                ingredientRecipeService.save(ingredientRecipe);
            }
        }

        actualizarCalorias();

        return recipe;
    }

    public void deleteById(Long id){
        recetaRepository.deleteById(id);
    }

    public Recipe findById(Long id){
        return recetaRepository.findById(id).orElse(null);
    }

    public List<Recipe> findAll(){
        return recetaRepository.findAll();
    }

    public Recipe update(Recipe recipe) {
        try {
            recetaRepository.findById(recipe.getIdRecipe());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }
        return recetaRepository.save(recipe);
    }

    public void actualizarCalorias(){
        recetaRepository.actualizarCalories();
    }
}
