package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.repository.IngredientRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientRecipeService {

    @Autowired
    IngredientRecipeRepository ingredientRecipeRepository;
}
