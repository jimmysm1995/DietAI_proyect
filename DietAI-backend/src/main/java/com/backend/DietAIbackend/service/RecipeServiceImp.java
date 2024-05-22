package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.IngredientInRecipe;
import com.backend.DietAIbackend.dto.RecipeWithIngredientsRequest;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.RecipeMapper;
import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.IngredientRecipe;
import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.model.RecipeAllergy;
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
    RecipeRepository recetaRepository;

    @Autowired
    IngredientRecipeService ingredientRecipeService;

    @Autowired
    RecipeAllergyService recipeAllergyService;

    @Autowired
    RecipeMapper recipeMapper;

    @Transactional
    @Override
    public Recipe save(Recipe receta, List<IngredientInRecipe> ingredientInRecipeList, List<Allergy> allergyList) {
        try {
            Recipe recipe = recetaRepository.save(receta);

            for (IngredientInRecipe ingredientInRecipe : ingredientInRecipeList) {
                if (ingredientInRecipe.getIngredient() != null) {
                    IngredientRecipe ingredientRecipe = new IngredientRecipe();
                    ingredientRecipe.setRecipe(recipe);
                    ingredientRecipe.setQuantity(ingredientInRecipe.getQuantity());
                    ingredientRecipe.setIngredient(ingredientInRecipe.getIngredient());
                    ingredientRecipeService.save(ingredientRecipe);
                }
            }

            for (Allergy allergy : allergyList) {
                recipeAllergyService.save(recipe, allergy);
            }

            actualizarCalorias();

            return recipe;
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("Ha habido un problema al guardar la receta en la base de datos", HttpStatus.CONFLICT);
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al guardar la receta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public RecipeWithIngredientsRequest getRecipeWithIngredients(Long idRecipe) {
        try {
            RecipeWithIngredientsRequest request = new RecipeWithIngredientsRequest();

            Recipe recipe = findById(idRecipe); // Este método ya lanza ServiceException si no encuentra la receta.

            List<IngredientInRecipe> ingredients = ingredientRecipeService.findAll().stream()
                    .filter(ingredientRecipe -> ingredientRecipe.getRecipe().equals(recipe))
                    .map(ingredientRecipe -> {
                        IngredientInRecipe ingredient = new IngredientInRecipe();
                        ingredient.setIngredient(ingredientRecipe.getIngredient());
                        ingredient.setQuantity(ingredientRecipe.getQuantity());
                        return ingredient;
                    })
                    .collect(Collectors.toList());

            request.setRecipe(recipeMapper.modelToDto(recipe));
            request.setIngredientInRecipe(ingredients);

            return request;
        } catch (ServiceException e) {
            // Si `findById` lanza una `ServiceException`, simplemente la dejamos pasar
            throw e;
        } catch (Exception e) {
            // Capturamos cualquier otra excepción inesperada
            throw new ServiceException("Ocurrió un error al obtener la receta con ingredientes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public List<Allergy> findAllAllergiesInRecipe(Long idRecipe) {
        try {
            Recipe recipe = findById(idRecipe); // Este método lanza ServiceException si no se encuentra la receta.

            List<Allergy> allergyList = recipe.getRecipeAllergy().stream()
                    .map(RecipeAllergy::getAllergy)
                    .collect(Collectors.toList());

            return allergyList;
        } catch (ServiceException e) {
            // Si `findById` lanza una `ServiceException`, simplemente la dejamos pasar.
            throw e;
        } catch (Exception e) {
            // Capturamos cualquier otra excepción inesperada.
            throw new ServiceException("Ocurrió un error al obtener las alergias de la receta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public void deleteById(Long id) {
        try {
            findById(id); // Este método lanza ServiceException si no se encuentra la receta.
            recetaRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Ocurrió un error inesperado al eliminar la receta");
        }
    }


    @Override
    public Recipe findById(Long id){
        return recetaRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado la receta", HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Recipe save(Recipe var1) {
        return recetaRepository.save(var1);
    }

    @Override
    public List<Recipe> findAll() {
        try {
            List<Recipe> recipes = recetaRepository.findAll();
            if (recipes.isEmpty()) {
                throw new ServiceException("No se encuentran recetas", HttpStatus.NOT_FOUND);
            }
            return recipes;
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al obtener las recetas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public Recipe update(Recipe recipe) {
        try {
            findById(recipe.getIdRecipe()); // Este método lanza ServiceException si no se encuentra la receta.
            return recetaRepository.save(recipe);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al actualizar la receta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void actualizarCalorias() {
        try {
            recetaRepository.actualizarCalories();
        } catch (Exception e) {
            throw new ServiceException("Ocurrió un error inesperado al actualizar las calorías", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
