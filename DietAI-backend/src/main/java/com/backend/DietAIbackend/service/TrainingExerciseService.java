package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.TrainingExercise;

import java.util.List;

public interface TrainingExerciseService {
    TrainingExercise save(TrainingExercise trainingExercise);

    void delete(TrainingExercise trainingExercise);

    List<TrainingExercise> findByExerciseIdExercise(long idExercicse);
}
