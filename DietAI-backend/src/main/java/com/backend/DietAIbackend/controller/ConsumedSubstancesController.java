package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ConsumedSubstancesDto;
import com.backend.DietAIbackend.dto.GenderDto;
import com.backend.DietAIbackend.model.ConsumedSubstances;
import com.backend.DietAIbackend.model.Gender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/consumedSubstances")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ConsumedSubstancesController {

    @GetMapping
    public ConsumedSubstancesDto[] getAllConsumedSubstances() {
        return Stream.of(ConsumedSubstances.values())
                .map(consumedSubstances -> {
                    ConsumedSubstancesDto dto = new ConsumedSubstancesDto();
                    dto.setName(consumedSubstances.getName());
                    return dto;
                })
                .toArray(ConsumedSubstancesDto[]::new);
    }
}
