package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.ImagenProfile;
import com.backend.DietAIbackend.repository.ImagenProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenProfileService{

    @Autowired
    private ImagenProfileRepository imagenProfileRepository;

    public List<ImagenProfile> getAllImagenProfile(){
        return imagenProfileRepository.findAll();
    }
}
