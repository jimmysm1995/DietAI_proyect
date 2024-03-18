package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDto {

    private Long id;

    private String name;

    private Integer calories;

    private List<RecipeDietDto> recipeDiets;

    private List<IngredientRecipeDto> ingredientRecipe;
}
