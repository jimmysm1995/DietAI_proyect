package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.PlanDto;
import com.backend.DietAIbackend.dto.PreviusLevelDto;
import com.backend.DietAIbackend.model.Plan;
import com.backend.DietAIbackend.model.PreviusLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/previusLevel")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PreviusLevelController {

    @GetMapping
    public PreviusLevelDto[] getAllPreviusLevel() {
        return Stream.of(PreviusLevel.values())
                .map(previusLevel -> {
                    PreviusLevelDto dto = new PreviusLevelDto();
                    dto.setName(previusLevel.getName());
                    return dto;
                })
                .toArray(PreviusLevelDto[]::new);
    }
}
