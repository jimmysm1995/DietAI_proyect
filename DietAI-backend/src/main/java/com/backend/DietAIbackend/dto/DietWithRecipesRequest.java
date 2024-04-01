package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class DietWithRecipesRequest {

    private DietDto diet;
    private List<RecipeInDiet> recipeInDiet;
}
