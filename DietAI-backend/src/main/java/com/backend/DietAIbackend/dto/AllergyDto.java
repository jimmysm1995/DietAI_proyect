package com.backend.DietAIbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class AllergyDto {

    @Schema(example = "1", description = "Id de alergia")
    private Long idAllergy;

    @Schema(example = "name", description = "nombre de la alergia")
    private String name;

    @Schema(example = "clientAllergy" , description = "Relacion para el cliente con la alergia")
    private List<ClientAllergyDto> clientAllergy;
}
