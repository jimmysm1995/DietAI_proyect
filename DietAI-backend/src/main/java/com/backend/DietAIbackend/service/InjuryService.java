package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Injury;
import com.backend.DietAIbackend.repository.InjuryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjuryService {

    @Autowired
    InjuryRepository injuryRepository;

    public Injury save(Injury injury){
        return injuryRepository.save(injury);
    }

    public Injury findById(Long id){
        return injuryRepository.findById(id).orElse(null);
    }

    public List<Injury> findAll(){return injuryRepository.findAll();}
    public void delete(Injury injury){ injuryRepository.delete(injury);}

    public void deleteById(Long id){ injuryRepository.deleteById(id);}

    public Injury update(Injury injury) {
        try {
            injuryRepository.findById(injury.getIdInjury());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No exista la lesion en cuestion");
        }

        return injuryRepository.save(injury);
    }
}
