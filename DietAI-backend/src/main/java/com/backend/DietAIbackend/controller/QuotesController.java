package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.service.QuotesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "QuotesController", description = "Endpoint para las frases que aparecerían en la home page")
public class QuotesController {

    @Autowired
    QuotesService quotesService;

    @GetMapping
    @Operation(summary = "Devuelve una frase aleatoria")
    public ResponseEntity<String> getRandomQuote() {

        return ResponseEntity.ok().body(quotesService.getRandomQuote().getName());
    }
}
