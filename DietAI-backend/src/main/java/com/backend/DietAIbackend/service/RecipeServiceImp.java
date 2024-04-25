package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.dto.RecipeWithIngredientsRequest;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImp implements RecipeService {

    @Autowired
    RecipeRepository recetaRepository;

    @Autowired
    IngredientRecipeService ingredientRecipeService;

    @Autowired
    RecipeMapper recipeMapper;

    @Transactional
    public Recipe save(Recipe receta, List<IngredientInRecipe> ingredientInRecipeList) {

        Recipe recipe = recetaRepository.save(receta);

        for (IngredientInRecipe ingredientInRecipe : ingredientInRecipeList
        ) {
            if (ingredientInRecipe.getIngredient() != null){
                IngredientRecipe ingredientRecipe = new IngredientRecipe();
                ingredientRecipe.setRecipe(recipe);
                ingredientRecipe.setQuantity(ingredientInRecipe.getQuantity());
                ingredientRecipe.setIngredient(ingredientInRecipe.getIngredient());
                ingredientRecipeService.save(ingredientRecipe);
            }
        }

        actualizarCalorias();

        return recipe;
    }

    @Override
    public RecipeWithIngredientsRequest getRecipeWithIngredients(Long idRecipe) {

        RecipeWithIngredientsRequest request = new RecipeWithIngredientsRequest();

        Recipe recipe = findById(idRecipe);

        List<IngredientInRecipe> ingredients = new ArrayList<>();

        for (IngredientRecipe ingredientRecipe : ingredientRecipeService.findAll()
        ) {
            if (ingredientRecipe.getRecipe() == recipe){
                IngredientInRecipe ingredient = new IngredientInRecipe();
                ingredient.setIngredient(ingredientRecipe.getIngredient());
                ingredient.setQuantity(ingredientRecipe.getQuantity());
                ingredients.add(ingredient);
            }
        }

        request.setRecipe(recipeMapper.modelToDto(recipe));
        request.setIngredientInRecipe(ingredients);

        return request;
    }

    public void deleteById(Long id){
        recetaRepository.deleteById(id);
    }

    public Recipe findById(Long id){
        return recetaRepository.findById(id).orElse(null);
    }

    @Override
    public Recipe save(Recipe var1) {
        return recetaRepository.save(var1);
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

    private void actualizarCalorias(){
        recetaRepository.actualizarCalories();
    }
}
