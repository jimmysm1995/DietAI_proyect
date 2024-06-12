package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ConsumedSubstancesDto;
import com.backend.DietAIbackend.dto.JobTypeDto;
import com.backend.DietAIbackend.model.ConsumedSubstances;
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
@RequestMapping("/api/jobType")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "JobTypeController", description = "Endpoint para los tipos de trabajo de los clientes")
@Slf4j
public class JobTypeController {

    @GetMapping
    @Operation(summary = "Devuelve una lista con los tipos de trabajo de los clientes")
    public List<JobType> getAllJobTypes() {
        return Arrays.asList(JobType.values());
    }
}
