package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.Muscle;

import java.util.List;

public interface ExerciseService extends ICrudService<Exercise, Long> {
    Exercise save(Exercise exercise, List<Muscle> muscleList);
    List<Exercise> findHomeExercises();
    List<Exercise> findGymExercises();
    List<Muscle> findAllmusclesInExercise(Long id);
}
