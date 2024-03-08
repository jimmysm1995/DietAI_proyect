package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDto {

    private Long idRecipe;

    private String name;

    private List<RecipeDietDto> recipeDiets;

    private List<IngredientRecipeDto> ingredientRecipe;
}
