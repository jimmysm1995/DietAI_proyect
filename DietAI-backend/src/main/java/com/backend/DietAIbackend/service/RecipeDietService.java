package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.RecipeDiet;

import java.util.List;

public interface RecipeDietService {
    RecipeDiet save(RecipeDiet recipeDiet);

    List<RecipeDiet> findAll();

    List<RecipeDiet> findByRecipeIdRecipe(Long idRecipe);

    void delete(RecipeDiet recipeDiet);
}
