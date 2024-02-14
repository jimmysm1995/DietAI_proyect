package com.dietai.dietai.dto;


import com.dietai.dietai.model.Muscle;
import lombok.Data;

import java.util.List;

@Data
public class GymExerciseDto {

    private String name;

    private List<Muscle> muscles;

    private Integer difficult;

    private String explanation;

    private List<TrainingExerciseDto> trainingExercises;
}
