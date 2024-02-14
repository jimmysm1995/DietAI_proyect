package com.dietai.dietai.service;

import com.dietai.dietai.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietService {

    @Autowired
    DietRepository dietRepository;

}
