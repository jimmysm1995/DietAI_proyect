package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.HomeExerciseMuscle;
import com.backend.DietAIbackend.model.Muscle;
import lombok.Data;

import java.util.List;

@Data
public class HomeExerciseDto {

    private Long id;

    private String name;

    private Integer difficult;

    private String explanation;

    private List<TrainingExerciseDto> trainingExercises;

    private List<HomeExerciseMuscleDto> homeExerciseMuscles;

}
