package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.dto.RecipeWithIngredientsRequest;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImp implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRecipeService ingredientRecipeService;

    @Autowired
    RecipeAllergyService recipeAllergyService;

    @Autowired
    RecipeMapper recipeMapper;

    @Autowired
    RecipeDietService recipeDietService;

    /**
     * Guarda la receta
     *
     * @param receta
     * @param ingredientInRecipeList
     * @param allergyList
     * @return
     */
    @Transactional
    @Override
    public Recipe save(Recipe receta, List<IngredientInRecipe> ingredientInRecipeList, List<Allergy> allergyList) {
        try {
            Recipe recipe = recipeRepository.save(receta);
            for (IngredientInRecipe ingredientInRecipe : ingredientInRecipeList) {
                if (ingredientInRecipe.getIngredient() != null) {
                    IngredientRecipe ingredientRecipe = IngredientRecipe.builder()
                            .recipe(recipe)
                            .quantity(ingredientInRecipe.getQuantity())
                            .ingredient(ingredientInRecipe.getIngredient())
                            .build();
                    ingredientRecipeService.save(ingredientRecipe);
                }
            }
            for (Allergy allergy : allergyList) {
                recipeAllergyService.save(recipe, allergy);
            }
            actualizarCalorias();
            return recipe;
        }  catch (Exception e) {
            throw new ServiceException("Ocurrió un error al guardar la receta", HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Devuelve la receta con sus ingredientes y cantidades
     *
     * @param idRecipe
     * @return
     */
    @Override
    public RecipeWithIngredientsRequest getRecipeWithIngredients(Long idRecipe) {
        try {

            Recipe recipe = findById(idRecipe); // Este método ya lanza ServiceException si no encuentra la receta.

            List<IngredientInRecipe> ingredients = ingredientRecipeService.findAll().stream()
                    .filter(ingredientRecipe -> ingredientRecipe.getRecipe().equals(recipe))
                    .map(ingredientRecipe -> {
                        IngredientInRecipe ingredient = IngredientInRecipe.builder()
                                .ingredient(ingredientRecipe.getIngredient())
                                .quantity(ingredientRecipe.getQuantity())
                                .build();
                        return ingredient;
                    })
                    .collect(Collectors.toList());

            RecipeWithIngredientsRequest request = RecipeWithIngredientsRequest.builder()
                    .recipe(recipeMapper.modelToDto(recipe))
                    .ingredientInRecipe(ingredients)
                    .build();

            return request;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Devuelve todas las alergias que tiene una receta
     *
     * @param idRecipe
     * @return
     */
    @Override
    public List<Allergy> findAllAllergiesInRecipe(Long idRecipe) {
        try {
            Recipe recipe = findById(idRecipe); // Este método lanza ServiceException si no se encuentra la receta.

            List<Allergy> allergyList = recipe.getRecipeAllergy().stream()
                    .map(RecipeAllergy::getAllergy)
                    .collect(Collectors.toList());

            return allergyList;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina la receta
     *
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        Recipe recipe = findById(id);

        // Eliminar manualmente los registros en ingredient_recipe relacionados con este ingrediente
        List<RecipeDiet> recipeDietList = recipeDietService.findByRecipeIdRecipe(id);
        for (RecipeDiet recipeDiet : recipeDietList) {
            recipeDietService.delete(recipeDiet);
        }

        // Finalmente, eliminar el ingrediente
        recipeRepository.delete(recipe);
    }


    /**
     * Encuentra la receta por el id
     *
     * @param id
     * @return
     */
    @Override
    public Recipe findById(Long id){
        return recipeRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado la receta", HttpStatus.NOT_FOUND)
        );
    }

    /**
     * Devuelve una lista con las recetas
     *
     * @return
     */
    @Override
    public List<Recipe> findAll() {
        try {
            List<Recipe> recipes = recipeRepository.findAll();
            if (recipes.isEmpty()) {
                throw new ServiceException("No se encuentran recetas", HttpStatus.NOT_FOUND);
            }
            return recipes;
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * Actualiza las recetas
     *
     * @param recipe
     * @return
     */
    @Override
    public Recipe update(Recipe recipe) {
        try {
            findById(recipe.getIdRecipe()); // Este método lanza ServiceException si no se encuentra la receta.
            return recipeRepository.save(recipe);
        } catch (Exception e) {
            throw e;
        }
    }

    private void actualizarCalorias() {
        try {
            recipeRepository.actualizarCalories();
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al actualizar las calorías", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
