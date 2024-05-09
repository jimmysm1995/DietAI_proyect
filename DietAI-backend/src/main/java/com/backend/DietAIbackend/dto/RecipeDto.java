package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
public class RecipeDto {

    @Schema(example = "1", description = "Id de la receta")
    private Long idRecipe;

    @Schema(example = "Ensalada de pollo", description = "Nombre de la receta")
    private String name;

    @Schema(example = "350", description = "Cantidad de calorías de la receta")
    private Integer calories;

    @Schema(example = "imagen", description = "Imagen para la receta")
    private String imageUrl;

    @Schema(example = "remojar la pasta, añadir sal, ...", description = "Pasos para realizar la receta")
    private String steps;

    @Schema(description = "Lista de alergias de la receta")
    private List<AllergyDto> allergy;

    @Schema(description = "Lista de dietas que incluyen esta receta")
    private List<RecipeDietDto> recipeDiets;

    @Schema(description = "Lista de ingredientes utilizados en esta receta")
    private List<IngredientRecipeDto> ingredientRecipe;
}

