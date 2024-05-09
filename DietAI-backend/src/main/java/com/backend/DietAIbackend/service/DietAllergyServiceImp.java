package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.model.DietAllergy;
import com.backend.DietAIbackend.model.RecipeAllergy;
import com.backend.DietAIbackend.repository.DietAllergyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietAllergyServiceImp implements DietAllergyService{

    @Autowired
    DietAllergyRepository dietAllergyRepository;
    @Override
    public List<DietAllergy> findAll() {
        return dietAllergyRepository.findAll();
    }

    @Override
    public DietAllergy findById(Long var1) {
        return dietAllergyRepository.findById(var1).orElse(null);
    }

    @Override
    public DietAllergy save(Diet diet, Allergy allergy) {
        DietAllergy dietAllergy = new DietAllergy();

        dietAllergy.setDiet(diet);
        dietAllergy.setAllergy(allergy);

        return dietAllergyRepository.save(dietAllergy);
    }

    @Override
    public void deleteById(Long var1) {
        dietAllergyRepository.deleteById(var1);
    }

    @Override
    public DietAllergy update(DietAllergy var1) {
        try {
            dietAllergyRepository.findById(var1.getIdDietAllergy());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No exista la relación en cuestion");
        }

        return dietAllergyRepository.save(var1);
    }
}
