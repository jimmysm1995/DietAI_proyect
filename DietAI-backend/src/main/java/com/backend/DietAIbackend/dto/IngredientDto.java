package com.backend.DietAIbackend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
@Builder
public class IngredientDto {

    @Schema(example = "1", description = "Id del ingrediente")
    private Long idIngredient;

    @Schema(example = "Arroz", description = "Nombre del ingrediente")
    private String name;

    @Schema(example = "3.5", description = "Cantidad de proteínas en gramos")
    private double protein;

    @Schema(example = "20.0", description = "Cantidad de carbohidratos en gramos")
    private double carbohydrates;

    @Schema(example = "1.5", description = "Cantidad de grasas en gramos")
    private double fats;

    @Schema(example = "100", description = "Cantidad de calorías")
    private Integer calories;

    @Schema(description = "Lista de ingredientes en recetas que contienen este ingrediente")
    private List<IngredientRecipeDto> ingredientRecipe;
}

