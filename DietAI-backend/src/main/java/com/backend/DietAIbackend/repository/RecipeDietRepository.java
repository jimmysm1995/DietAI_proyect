package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.RecipeDiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDietRepository extends JpaRepository<RecipeDiet,Long> {

    List<RecipeDiet> findByRecipeIdRecipe(Long idRecipe);
}
