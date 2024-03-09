package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.DietRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietService {

    @Autowired
    DietRepository dietRepository;

    public Diet save(Diet diet){
        return dietRepository.save(diet);
    }

    public Diet findById(Long id){
        return dietRepository.findById(id).orElse(null);
    }

    public List<Diet> findAll(){return dietRepository.findAll();}
    public void delete(Diet diet){ dietRepository.delete(diet);}

    public void deleteById(Long id){ dietRepository.deleteById(id);}

    public Diet update(Diet diet) {
        try {
            dietRepository.findById(diet.getIdDiet());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el cliente en cuestion");
        }

        return dietRepository.save(diet);
    }

}
