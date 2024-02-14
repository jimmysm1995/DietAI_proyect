package com.dietai.dietai.service;


import com.dietai.dietai.repository.IngredientRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientRecipeService {

    @Autowired
    IngredientRecipeRepository ingredientRecipeRepository;
}
