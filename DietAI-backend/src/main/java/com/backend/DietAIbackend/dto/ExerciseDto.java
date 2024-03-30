package com.backend.DietAIbackend.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class ExerciseDto {

    @Schema(example = "1", description = "Id del ejercicio de entrenamiento en casa")
    private Long idExercise;

    @Schema(example = "Plancha", description = "Nombre del ejercicio")
    private String name;

    @Schema(example = "https://...", description = "url de la imagen del ejercicio")
    private String imgExercise;

    @Schema(example = "Debes colocar las manos...", description = "Explicación del ejercicio")
    private String initialPosition;

    @Schema(example = "Piensa en colocar...", description = "Explicación del ejercicio")
    private String execution;

    @Schema(example = "Debes mantener la espalda ...", description = "Explicación del ejercicio")
    private String advices;

    @Schema(description = "Lista de ejercicios de entrenamiento asociados a este ejercicio en casa")
    private List<TrainingExerciseDto> trainingExercises;

    @Schema(description = "Lista de músculos trabajados por este ejercicio en casa")
    private List<ExerciseMuscleDto> ExerciseMuscles;
}
