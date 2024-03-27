package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecetaController {

    @Autowired
    RecipeService recipeService;

    @PostMapping("/actualizar")
    public void actualizarCalorias(){
        recipeService.actualizarCalorias();
    }
}
