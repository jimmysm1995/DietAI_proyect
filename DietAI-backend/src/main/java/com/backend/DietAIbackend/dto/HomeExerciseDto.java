package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.HomeExerciseMuscle;
import com.backend.DietAIbackend.model.Muscle;
import lombok.Data;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
public class HomeExerciseDto {

    @Schema(example = "1", description = "Id del ejercicio de entrenamiento en casa")
    private Long idHomeExercise;

    @Schema(example = "Plancha", description = "Nombre del ejercicio")
    private String name;

    @Schema(example = "3", description = "Nivel de dificultad del ejercicio")
    private Integer difficult;

    @Schema(example = "Este ejercicio consiste en...", description = "Explicación del ejercicio")
    private String explanation;

    @Schema(description = "Lista de ejercicios de entrenamiento asociados a este ejercicio en casa")
    private List<TrainingExerciseDto> trainingExercises;

    @Schema(description = "Lista de músculos trabajados por este ejercicio en casa")
    private List<HomeExerciseMuscleDto> homeExerciseMuscles;
}
