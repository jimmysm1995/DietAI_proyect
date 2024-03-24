package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.GymExerciseMuscle;
import com.backend.DietAIbackend.model.HomeExerciseMuscle;
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
    private List<HomeExerciseMuscleDto> homeExerciseMuscles;

    @Schema(description = "Lista de ejercicios de gimnasio que implican este músculo")
    private List<GymExerciseMuscleDto> gymExerciseMuscles;
}

