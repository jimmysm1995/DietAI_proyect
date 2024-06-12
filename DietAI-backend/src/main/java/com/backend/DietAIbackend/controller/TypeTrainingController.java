package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.PreviusLevel;
import com.backend.DietAIbackend.model.TypeTraining;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "TypeTrainingController", description = "Endpoint para los lugares donde entrenar")
@Slf4j
public class TypeTrainingController {

    @GetMapping
    @Operation(summary = "Devuelve una lista con los lugares donde entrenar")
    public List<TypeTraining> getAllTypeTraining() {
        return Arrays.asList(TypeTraining.values());
    }
}
