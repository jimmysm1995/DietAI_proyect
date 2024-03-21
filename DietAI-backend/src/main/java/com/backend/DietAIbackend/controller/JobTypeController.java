package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ConsumedSubstancesDto;
import com.backend.DietAIbackend.dto.JobTypeDto;
import com.backend.DietAIbackend.model.ConsumedSubstances;
import com.backend.DietAIbackend.model.JobType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/jobType")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class JobTypeController {

    @GetMapping
    public JobTypeDto[] getAllJobTypes() {
        return Stream.of(JobType.values())
                .map(jobTypes -> {
                    JobTypeDto dto = new JobTypeDto();
                    dto.setName(jobTypes.getName());
                    return dto;
                })
                .toArray(JobTypeDto[]::new);
    }
}
