package com.backend.DietAIbackend.dto;


import lombok.Data;

@Data
public class ExerciseMuscleDto {

    private Long idExerciseMuscle;

    private ExerciseDto Exercise;

    private MuscleDto muscle;



}
