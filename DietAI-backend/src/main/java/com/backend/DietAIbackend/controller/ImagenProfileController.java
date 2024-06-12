package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.ImagenProfile;
import com.backend.DietAIbackend.service.ImagenProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/imagenProfiles")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
@Tag(name = "ImagenProfileController", description = "Endpoint para las imagenes de perfil de los usuarios")
public class ImagenProfileController {

    @Autowired
    private ImagenProfileService imagenProfileService;

    @GetMapping("/urls")
    @Operation(summary = "Devuelve todas las imágenes de perfil")
    public List<String> getAllImageUrls() {
        List<ImagenProfile> imagenProfiles = imagenProfileService.getAllImagenProfile();
        return imagenProfiles.stream()
                .map(ImagenProfile::getUrl)
                .collect(Collectors.toList());
    }
}
