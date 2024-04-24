package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.ExercisesInTraining;
import com.backend.DietAIbackend.model.Training;

import java.util.List;

public interface TrainingService extends ICrudService<Training, Long> {

    Training save(Training training, List<ExercisesInTraining> exercisesInTrainingList);
    List<ExercisesInTraining> findExercisesById(Long id);
}
