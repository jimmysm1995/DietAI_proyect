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

    /**
     * Guarda la relacion entre ingredientes y recetas
     *
     * @param ingredientRecipe
     * @return
     */
    public IngredientRecipe save(IngredientRecipe ingredientRecipe){
        return ingredientRecipeRepository.save(ingredientRecipe);
    }

    /**
     * Encuentra todas las relaciones
     *
     * @return
     */
    @Override
    public List<IngredientRecipe> findAll() {
        return ingredientRecipeRepository.findAll();
    }

    /**
     *
     * Devuelve las relaciones que están relacionadas con el ingrediente que se envia
     *
     * @param idIngredient
     * @return
     */
    @Override
    public List<IngredientRecipe> findByIngredientIdIngredient(Long idIngredient) {
        return ingredientRecipeRepository.findByIngredientIdIngredient(idIngredient);
    }

    /**
     * Elimina la relación
     *
     * @param ingredientRecipe
     */
    @Override
    public void delete(IngredientRecipe ingredientRecipe) {
        ingredientRecipeRepository.delete(ingredientRecipe);
    }
}
