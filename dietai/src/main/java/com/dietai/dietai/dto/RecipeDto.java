package com.dietai.dietai.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDto {

    private String name;

    private List<RecipeDietDto> recipeDiets;

    private List<IngredientRecipeDto> ingredientRecipe;
}
