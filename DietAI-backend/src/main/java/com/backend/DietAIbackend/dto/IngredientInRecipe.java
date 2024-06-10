package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Ingredient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientInRecipe {
    Ingredient ingredient;
    double quantity;
}
