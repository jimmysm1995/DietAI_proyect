package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.DayWeek;
import com.backend.DietAIbackend.model.JobType;
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
@RequestMapping("/api/dayOfWeek")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
@Tag(name = "DayOfWeekController", description = "Endpoint para los dias de la semana")
public class DayOfWeekController {

    @GetMapping
    @Operation(summary = "Devuelve una lista con los dias de la semana")
    public List<DayWeek> getAllDayOfWeek() {
        return Arrays.asList(DayWeek.values());
    }
}
