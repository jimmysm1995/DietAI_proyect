package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Muscle;
import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
public class GymExerciseDto {

    @Schema(example = "1", description = "Id del ejercicio en el gimnasio")
    private Long idGymExercise;

    @Schema(example = "Sentadillas", description = "Nombre del ejercicio")
    private String name;

    @Schema(example = "5", description = "Nivel de dificultad del ejercicio")
    private Integer difficult;

    @Schema(example = "Este ejercicio consiste en...", description = "Explicación del ejercicio")
    private String explanation;

    @Schema(description = "Lista de ejercicios de entrenamiento asociados a este ejercicio en el gimnasio")
    private List<TrainingExerciseDto> trainingExercises;

    @Schema(description = "Lista de músculos trabajados por este ejercicio en el gimnasio")
    private List<GymExerciseMuscleDto> gymExerciseMuscles;
}

