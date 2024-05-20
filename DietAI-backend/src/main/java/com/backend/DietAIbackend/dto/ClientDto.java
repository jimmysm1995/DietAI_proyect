package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.List;

@Data
public class ClientDto {

    @Schema(example = "1", description = "Id del cliente")
    private Long idClient;

    @Schema(example = "1990-01-01", description = "Fecha de nacimiento del cliente")
    private LocalDate birthDate;

    @Schema(description = "Plan del cliente")
    private Plan plan;

    @Schema(description = "Género del cliente")
    private Gender gender;

    @Schema(example = "70.5", description = "Peso del cliente en kilogramos")
    private Float weight;

    @Schema(example = "175.0", description = "Altura del cliente en centímetros")
    private Float height;

    @Schema(example = "1800", description = "Calorias diarias recomendadas")
    private Integer recommendedDailyCalories;

    @Schema(description = "Objetivo del cliente")
    private Goal goal;

    @Schema(description = "Lista de lesiones del cliente")
    private List<InjuryDto> injury;

    @Schema(description = "Lista de alergias del cliente")
    private List<AllergyDto> allergy;

    @Schema(description = "Tipo de trabajo del cliente")
    private JobType jobType;

    @Schema(description = "Nivel previo de entrenamiento del cliente")
    private PreviusLevel previousLevel;

    @Schema(description = "Sustancias consumidas por el cliente")
    private ConsumedSubstances consumedSubstances;

    @Schema(example = "4", description = "Tiempo de entrenamiento semanal en dias")
    private Integer trainingTime;

    @Schema(example = "GYM", description = "Donde va a realizar el entrenamiento")
    private TypeTraining typeTraining;

    @Schema(description = "Usuario asociado al cliente")
    private UserDto user;

    @Schema(description = "Entrenamiento del cliente")
    private TrainingDto training;

    @Schema(description = "Dieta del cliente")
    private DietDto diet;

}

