package com.dietai.dietai.service;


import com.dietai.dietai.repository.RecipeDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeDietService {

    @Autowired
    RecipeDietRepository recipeDietRepository;
}
