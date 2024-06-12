package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.PreviusLevel;
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
@RequestMapping("/api/previusLevel")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "PreviusLevelController", description = "Endpoint para el nivel de los clientes")
@Slf4j
public class PreviusLevelController {

    @GetMapping
    @Operation(summary = "Devuelve una lista con los niveles de los clientes")
    public List<PreviusLevel> getAllPreviusLevel() {
        return Arrays.asList(PreviusLevel.values());
    }
}
