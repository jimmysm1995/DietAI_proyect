package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Training;
import lombok.Data;

import java.util.List;

@Data
public class TrainingWithExercisesRequest {

    private TrainingDto training;

    private List<ExercisesInTraining> exercisesInTraining;
}
