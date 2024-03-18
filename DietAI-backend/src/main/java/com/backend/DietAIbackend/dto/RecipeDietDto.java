package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.MealTime;
import lombok.Data;

import java.time.DayOfWeek;

@Data
public class RecipeDietDto {

    private Long id;

    private DietDto diet;

    private RecipeDto recipe;

    private DayOfWeek dayOfWeek;

    private MealTime mealTime;
}
