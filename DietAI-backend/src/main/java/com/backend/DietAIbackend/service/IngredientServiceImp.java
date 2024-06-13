package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.repository.IngredientRecipeRepository;
import com.backend.DietAIbackend.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    IngredientRecipeService ingredientRecipeService;

    /**
     * Guarda el ingrediente
     *
     * @param ingredient
     * @return
     */
    @Transactional
    @Override
    public Ingredient save(Ingredient ingredient) {
        try {
            return ingredientRepository.save(ingredient);
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error al guardar el ingrediente", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Encuentra el ingrediente por su id
     *
     * @param id
     * @return
     */
    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new ServiceException("No se ha encontrado el ingrediente", HttpStatus.NOT_FOUND));
    }

    /**
     * Devuelve una lista con todos los ingredientes
     *
     * @return
     */
    @Override
    public List<Ingredient> findAll() {
        List<Ingredient> ingredients = ingredientRepository.findAllByOrderByNameAsc();
        if (ingredients.isEmpty()) {
            throw new ServiceException("No se encuentran ingredientes", HttpStatus.NOT_FOUND);
        }
        return ingredients;
    }

    /**
     * Elimina un ingrediente por el id
     *
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        // Verificar si el ingrediente existe
        Ingredient ingredient = findById(id);

        // Eliminar manualmente los registros en ingredient_recipe relacionados con este ingrediente
        List<IngredientRecipe> ingredientRecipes = ingredientRecipeService.findByIngredientIdIngredient(id);
        for (IngredientRecipe ingredientRecipe : ingredientRecipes) {
            ingredientRecipeService.delete(ingredientRecipe);
        }

        // Finalmente, eliminar el ingrediente
        ingredientRepository.delete(ingredient);
    }


    /**
     * Actualiza un ingrediente
     *
     * @param ingredient
     * @return
     */
    @Override
    public Ingredient update(Ingredient ingredient) {
        if (!ingredientRepository.existsById(ingredient.getIdIngredient())) {
            throw new ServiceException("No se encontró el ingrediente para actualizar", HttpStatus.NOT_FOUND);
        }
        return ingredientRepository.save(ingredient);
    }
}

