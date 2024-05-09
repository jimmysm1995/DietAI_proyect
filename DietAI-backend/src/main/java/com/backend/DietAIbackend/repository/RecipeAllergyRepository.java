package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.RecipeAllergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeAllergyRepository extends JpaRepository<RecipeAllergy, Long> {
}
