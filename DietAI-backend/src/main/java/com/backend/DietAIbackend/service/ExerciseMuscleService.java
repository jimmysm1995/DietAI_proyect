package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Exercise;
import com.backend.DietAIbackend.model.ExerciseMuscle;
import com.backend.DietAIbackend.model.Muscle;

public interface ExerciseMuscleService {
    ExerciseMuscle save(Exercise exercise, Muscle muscle);
}
