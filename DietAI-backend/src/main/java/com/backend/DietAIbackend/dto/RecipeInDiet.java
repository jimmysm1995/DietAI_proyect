package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.MealTime;

import java.time.DayOfWeek;

public record RecipeInDiet(Long id, String name, Integer calories, DayOfWeek day, MealTime mealTime) {
}
