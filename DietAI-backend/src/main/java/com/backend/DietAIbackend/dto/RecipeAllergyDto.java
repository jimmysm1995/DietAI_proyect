package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class RecipeAllergyDto {

    private Long idRecipeAllergy;

    private RecipeDto recipe;

    private AllergyDto allergy;
}
