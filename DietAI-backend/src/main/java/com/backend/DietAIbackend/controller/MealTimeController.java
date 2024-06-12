package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.MealTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/mealTime")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "MealTimeController", description = "Endpoint para los tiempos de las comidas en las dietas")
@Slf4j
public class MealTimeController {

    @GetMapping
    @Operation(summary = "Devuelve una lista con los tiempos de las comidas en las dietas")
    public List<MealTime> getAllMealTime() {
        return Arrays.asList(MealTime.values());
    }
}
