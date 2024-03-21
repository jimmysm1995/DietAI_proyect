package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.GenderDto;
import com.backend.DietAIbackend.model.Gender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/gender")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class GenderController {

    @GetMapping
    public GenderDto[] getAllGeneros() {
        return Stream.of(Gender.values())
                .map(genero -> {
                    GenderDto dto = new GenderDto();
                    dto.setName(genero.getName());
                    return dto;
                })
                .toArray(GenderDto[]::new);
    }
}
