package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository <Recipe,Long> {
}
