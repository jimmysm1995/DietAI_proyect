package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.TrainingExercise;
import com.backend.DietAIbackend.model.TypeTraining;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
public class TrainingDto {

    @Schema(example = "1", description = "Id del entrenamiento")
    private Long idTraining;

    @Schema(example = "Entrenamiento de fuerza", description = "Nombre del entrenamiento")
    private String name;

    @Schema(description = "Tipo de entrenamiento")
    private TypeTraining typeTraining;

    @Schema(example = "5", description = "Dificultad del entrenamiento")
    private Integer difficulty;

    @Schema(example = "3", description = "Número de días por semana")
    private Integer days;

    @Schema(example = "FullBody", description = "Distribución de los ejercicios por días")
    private String distribution;

    @Schema(description = "Lista de clientes asociados a este entrenamiento")
    private List<ClientDto> clients;

    @Schema(description = "Lista de ejercicios asociados a este entrenamiento")
    private List<TrainingExerciseDto> trainingExercises;
}
