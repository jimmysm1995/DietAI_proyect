package com.dietai.dietai.dto;

import lombok.Data;

@Data
public class TrainingExerciseDto {

    private int sets;

    private int repetitions;

    private TrainingDto training;

    private GymExerciseDto gymExercise;

    private HomeExerciseDto homeExercise;
}
