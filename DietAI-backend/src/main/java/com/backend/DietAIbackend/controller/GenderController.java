package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.GenderDto;
import com.backend.DietAIbackend.model.Gender;
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
@RequestMapping("/api/gender")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class GenderController {

    @GetMapping
    public List<Gender> getAllGender() {
        return Arrays.asList(Gender.values());
    }
}
