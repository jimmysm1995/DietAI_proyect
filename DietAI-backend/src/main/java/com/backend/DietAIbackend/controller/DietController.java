package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.service.DietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diet")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class DietController {

    @Autowired
    DietService dietService;

}
