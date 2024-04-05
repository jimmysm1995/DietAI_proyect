package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.GoalDto;
import com.backend.DietAIbackend.dto.PlanDto;
import com.backend.DietAIbackend.model.Gender;
import com.backend.DietAIbackend.model.Goal;
import com.backend.DietAIbackend.model.Plan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/plan")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class PlanController {

    @GetMapping
    public List<Plan> getAllPlan() {
        return Arrays.asList(Plan.values());
    }
}
