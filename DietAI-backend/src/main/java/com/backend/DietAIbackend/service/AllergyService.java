package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.repository.AllergyRepository;
import com.backend.DietAIbackend.repository.InjuryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyService {

    @Autowired
    AllergyRepository allergyRepository;

    public Allergy save(Allergy allergy){
        return allergyRepository.save(allergy);
    }

    public Allergy findById(Long id){
        return allergyRepository.findById(id).orElse(null);
    }

    public List<Allergy> findAll(){return allergyRepository.findAll();}
    public void delete(Allergy allergy){ allergyRepository.delete(allergy);}

    public void deleteById(Long id){ allergyRepository.deleteById(id);}

    public Allergy update(Allergy allergy) {
        try {
            allergyRepository.findById(allergy.getIdAllergy());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No exista la alergia en cuestion");
        }

        return allergyRepository.save(allergy);
    }
}
