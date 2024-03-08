package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Ingredient;
import com.backend.DietAIbackend.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public Ingredient registerIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
}
