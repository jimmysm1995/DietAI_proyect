package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Muscle;
import lombok.Data;

import java.util.List;

@Data
public class HomeExerciseDto {

    private String name;

    private List<Muscle> muscles;

    private Integer difficult;

    private String explanation;

    private List<TrainingExerciseDto> trainingExercises;
}
