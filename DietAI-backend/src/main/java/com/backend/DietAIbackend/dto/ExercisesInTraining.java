package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Exercise;

import java.time.DayOfWeek;

public record ExercisesInTraining(Exercise exercise, Integer sets, Integer reps, DayOfWeek dia) {
}
