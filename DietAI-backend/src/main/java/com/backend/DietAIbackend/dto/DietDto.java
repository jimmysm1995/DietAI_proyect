package com.backend.DietAIbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class DietDto {

    @Schema(example = "1", description = "Id de la dieta")
    private Long idDiet;

    @Schema(example = "Dieta", description = "Nombre de la dieta")
    private String name;

    @Schema(example = "2000", description = "Cantidad de calorías")
    private Integer calories;

    @Schema(description = "Lista de alergias de la dieta")
    private List<AllergyDto> allergy;

    @Schema(description = "Lista de recetas asociadas a la dieta")
    private List<RecipeDietDto> recipeDiets;

    @Schema(description = "Lista de clientes que siguen esta dieta")
    private List<ClientDto> clients;
}

