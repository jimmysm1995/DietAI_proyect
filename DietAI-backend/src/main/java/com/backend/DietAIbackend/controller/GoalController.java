package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.GoalDto;
import com.backend.DietAIbackend.dto.JobTypeDto;
import com.backend.DietAIbackend.model.Gender;
import com.backend.DietAIbackend.model.Goal;
import com.backend.DietAIbackend.model.JobType;
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
public class GoalController {

    @GetMapping
    public List<Goal> getAllGoal() {
        return Arrays.asList(Goal.values());
    }
}
