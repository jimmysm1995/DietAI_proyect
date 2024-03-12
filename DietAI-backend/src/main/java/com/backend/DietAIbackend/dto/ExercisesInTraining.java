package com.backend.DietAIbackend.dto;

import java.time.DayOfWeek;

public record ExercisesInTraining(String exerciseName, Integer sets, Integer reps, DayOfWeek dia) {
}
