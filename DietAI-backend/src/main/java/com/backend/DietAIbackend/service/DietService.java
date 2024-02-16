package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietService {

    @Autowired
    DietRepository dietRepository;

}
