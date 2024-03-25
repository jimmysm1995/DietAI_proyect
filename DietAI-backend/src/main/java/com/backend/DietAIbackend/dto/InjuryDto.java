package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.ClientInjury;
import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
public class InjuryDto {

    @Schema(example = "1", description = "Id de la lesión")
    private Long idInjury;

    @Schema(example = "Esguince de tobillo", description = "Nombre de la lesión")
    private String name;

    @Schema(description = "Lista de clientes afectados por esta lesión")
    private List<ClientInjuryDto> clientInjury;
}

