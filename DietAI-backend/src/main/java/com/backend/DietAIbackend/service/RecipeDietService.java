package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Recipe;
import com.backend.DietAIbackend.model.RecipeDiet;
import com.backend.DietAIbackend.repository.RecipeDietRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDietService {

    @Autowired
    RecipeDietRepository recipeDietRepository;

    public void save(RecipeDiet recipeDiet){
        recipeDietRepository.save(recipeDiet);
    }

    public void delete(RecipeDiet recipeDiet){
        recipeDietRepository.delete(recipeDiet);
    }

    public RecipeDiet findById(Long id){
        return recipeDietRepository.findById(id).orElse(null);
    }

    public List<RecipeDiet> findAll(){
        return recipeDietRepository.findAll();
    }

    public RecipeDiet update(RecipeDiet recipeDiet) {
        try {
            recipeDietRepository.findById(recipeDiet.getIdRecipeDiet());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe La receta en cuestion");
        }
        return recipeDietRepository.save(recipeDiet);
    }
}
