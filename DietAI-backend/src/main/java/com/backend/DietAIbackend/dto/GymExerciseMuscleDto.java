package com.backend.DietAIbackend.dto;


import lombok.Data;

@Data
public class GymExerciseMuscleDto {

    private Long id;

    private GymExerciseDto gymExercise;

    private MuscleDto muscle;



}
