package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class TrainingExerciseDto {

    private Long idTrainingExercise;

    private int sets;

    private int repetitions;

    private TrainingDto training;

    private GymExerciseDto gymExercise;

    private HomeExerciseDto homeExercise;
}
