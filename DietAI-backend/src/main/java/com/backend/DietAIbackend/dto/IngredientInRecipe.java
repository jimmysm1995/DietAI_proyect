package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Ingredient;
import lombok.Data;

@Data
public class IngredientInRecipe {
    Ingredient ingredient;
    double quantity;
}
