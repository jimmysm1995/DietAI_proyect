package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class TrainingExerciseDto {

    private Long id;

    private int sets;

    private int repetitions;

    private DayOfWeek dayWeek;

    private TrainingDto training;

    private GymExerciseDto gymExercise;

    private HomeExerciseDto homeExercise;
}
