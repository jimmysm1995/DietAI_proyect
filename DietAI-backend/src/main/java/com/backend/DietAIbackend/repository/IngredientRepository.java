package com.backend.DietAIbackend.repository;

import com.backend.DietAIbackend.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    List<Ingredient> findAllByOrderByNameAsc();
}
