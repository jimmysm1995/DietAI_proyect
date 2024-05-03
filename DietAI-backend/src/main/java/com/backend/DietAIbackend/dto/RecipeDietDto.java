package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.DayWeek;
import com.backend.DietAIbackend.model.MealTime;
import lombok.Data;

import java.time.DayOfWeek;

@Data
public class RecipeDietDto {

    private Long idRecipeDiet;

    private DietDto diet;

    private RecipeDto recipe;

    private DayWeek dayWeek;

    private MealTime mealTime;
}
