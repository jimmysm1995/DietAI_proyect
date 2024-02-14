package com.backend.DietAIbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index"; // Nombre de la página de inicio (index.html, index.jsp, etc.)
    }
}
