package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.GoalDto;
import com.backend.DietAIbackend.dto.JobTypeDto;
import com.backend.DietAIbackend.model.Gender;
import com.backend.DietAIbackend.model.Goal;
import com.backend.DietAIbackend.model.JobType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/goal")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
@Tag(name = "GoalController", description = "Endpoint para el objetivo de los clientes")
public class GoalController {

    @GetMapping
    @Operation(summary = "Devuelve una lista con los objetivos de los clientes")
    public List<Goal> getAllGoal() {
        return Arrays.asList(Goal.values());
    }
}
