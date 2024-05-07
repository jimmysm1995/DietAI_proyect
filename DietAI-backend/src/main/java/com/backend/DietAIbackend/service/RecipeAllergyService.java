package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;

import java.util.List;

public interface RecipeAllergyService {

    List<RecipeAllergy> findAll();
    RecipeAllergy findById(Long var1);
    RecipeAllergy save(Recipe recipe, Allergy allergy);
    void deleteById(Long var1);
    RecipeAllergy update(RecipeAllergy var1);
}
