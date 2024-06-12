package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;

import java.util.List;

public interface RecipeAllergyService {

    RecipeAllergy save(Recipe recipe, Allergy allergy);
}
