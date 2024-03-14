package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.service.QuotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class QuotesController {

    @Autowired
    QuotesService quotesService;

    @GetMapping
    public ResponseEntity<String> getRandomQuote() {

        return ResponseEntity.ok().body(quotesService.getRandomQuote().getName());
    }
}
