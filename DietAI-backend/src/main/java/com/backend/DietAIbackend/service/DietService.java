package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.IngredientSummary;
import com.backend.DietAIbackend.dto.RecipeInDiet;
import com.backend.DietAIbackend.model.Diet;

import java.util.List;

public interface DietService extends ICrudService<Diet, Long> {
    Diet save(Diet diet, List<RecipeInDiet> recipeInDietList);
    List<IngredientSummary> getListaCompra(Long id);
    List<RecipeInDiet> findRecipesByDiet(Long id);
}
