package com.dietai.dietai.dto;

import com.dietai.dietai.model.MealTime;
import lombok.Data;

import java.time.DayOfWeek;

@Data
public class RecipeDietDto {

    private DietDto diet;

    private RecipeDto recipe;

    private DayOfWeek dayOfWeek;

    private MealTime mealTime;
}
