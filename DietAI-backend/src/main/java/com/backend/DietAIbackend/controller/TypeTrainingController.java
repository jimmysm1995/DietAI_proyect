package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.PreviusLevel;
import com.backend.DietAIbackend.model.TypeTraining;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/typeTraining")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class TypeTrainingController {

    @GetMapping
    public List<TypeTraining> getAllTypeTraining() {
        return Arrays.asList(TypeTraining.values());
    }
}
