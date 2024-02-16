package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.repository.RecipeDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeDietService {

    @Autowired
    RecipeDietRepository recipeDietRepository;
}
