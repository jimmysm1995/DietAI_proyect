package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Exercise;

public record ExercisesInTraining(Exercise exercise, Integer sets, Integer reps, Integer orderDay, Integer orderWeek) {
}
