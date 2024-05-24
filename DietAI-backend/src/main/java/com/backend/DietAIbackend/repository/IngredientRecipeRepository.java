package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.IngredientRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRecipeRepository extends JpaRepository<IngredientRecipe,Long> {

    List<IngredientRecipe> findByIngredientIdIngredient(Long idIngredient);

}
