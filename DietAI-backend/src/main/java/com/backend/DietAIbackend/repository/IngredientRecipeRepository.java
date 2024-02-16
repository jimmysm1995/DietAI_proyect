package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.IngredientRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRecipeRepository extends JpaRepository<IngredientRecipe,Long> {
}
