package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.HomeExercise;
import com.backend.DietAIbackend.model.Muscle;
import lombok.Data;

@Data
public class HomeExerciseMuscleDto {

    private Long id;

    private HomeExerciseDto homeExercise;

    private MuscleDto muscle;


}
