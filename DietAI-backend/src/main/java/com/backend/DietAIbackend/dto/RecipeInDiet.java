package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.MealTime;
import com.backend.DietAIbackend.model.Recipe;

import java.time.DayOfWeek;

public record RecipeInDiet(Recipe recipe, DayOfWeek day, MealTime mealTime) {
}
