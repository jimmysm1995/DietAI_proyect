package com.backend.DietAIbackend.dto;


import lombok.Data;

@Data
public class GymExerciseMuscleDto {

    private Long idGymExerciseMuscle;

    private GymExerciseDto gymExercise;

    private MuscleDto muscle;



}
