package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.TrainingExercise;
import com.backend.DietAIbackend.model.TypeTraining;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
public class TrainingDto {

    private Long id;

    private String name;

    private TypeTraining typeTraining;

    private Integer difficulty;

    private Integer days;

    private String distribution;

    private List<ClientDto> clients;

    private List<TrainingExerciseDto> trainingExercises;
}
