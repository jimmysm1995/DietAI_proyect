package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.PlanDto;
import com.backend.DietAIbackend.dto.PreviusLevelDto;
import com.backend.DietAIbackend.model.JobType;
import com.backend.DietAIbackend.model.Plan;
import com.backend.DietAIbackend.model.PreviusLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/previusLevel")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class PreviusLevelController {

    @GetMapping
    public List<PreviusLevel> getAllPreviusLevel() {
        return Arrays.asList(PreviusLevel.values());
    }
}
