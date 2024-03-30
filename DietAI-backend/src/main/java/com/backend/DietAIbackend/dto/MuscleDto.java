package com.backend.DietAIbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class MuscleDto {

    @Schema(example = "1", description = "Id del músculo")
    private Long idMuscle;

    @Schema(example = "Bíceps", description = "Nombre del músculo")
    private String name;

    @Schema(description = "Lista de ejercicios de entrenamiento en casa que implican este músculo")
    private List<ExerciseMuscleDto> exerciseMuscles;

}

