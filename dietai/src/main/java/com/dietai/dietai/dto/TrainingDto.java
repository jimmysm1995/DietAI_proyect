package com.dietai.dietai.dto;

import com.dietai.dietai.model.TypeTraining;
import lombok.Data;

import java.util.List;

@Data

public class TrainingDto {

    private String name;

    private TypeTraining typeTraining;

    private Integer difficulty;

    private Integer days;

    private String distribution;

    private List<ClientDto> clients;

    private List<TrainingExerciseDto> trainingExercises;
}
