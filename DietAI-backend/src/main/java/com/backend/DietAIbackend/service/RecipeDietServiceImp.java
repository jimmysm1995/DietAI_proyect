package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.RecipeDiet;
import com.backend.DietAIbackend.repository.RecipeDietRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDietServiceImp implements RecipeDietService{

    @Autowired
    RecipeDietRepository recipeDietRepository;

    public RecipeDiet save(RecipeDiet recipeDiet){
         return recipeDietRepository.save(recipeDiet);
    }

    @Override
    public List<RecipeDiet> findAll() {
        return recipeDietRepository.findAll();
    }

    @Override
    public List<RecipeDiet> findByRecipeIdRecipe(Long idRecipe) {
        return recipeDietRepository.findByRecipeIdRecipe(idRecipe);
    }

    @Override
    public void delete(RecipeDiet recipeDiet) {

        recipeDietRepository.delete(recipeDiet);
    }
}
