package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.ClientInjuryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientInjuryService {

    @Autowired
    ClientInjuryRepository clientInjuryRepository;

    public ClientInjury save(Client client, Injury injury){

        ClientInjury clientInjury = new ClientInjury();

        clientInjury.setClient(client);
        clientInjury.setInjury(injury);

        return clientInjuryRepository.save(clientInjury);
    }

    public ClientInjury findById(Long id){
        return clientInjuryRepository.findById(id).orElse(null);
    }

    public List<ClientInjury> findAll(){return clientInjuryRepository.findAll();}
    public void delete(ClientInjury clientInjury){ clientInjuryRepository.delete(clientInjury);}

    public void deleteById(Long id){ clientInjuryRepository.deleteById(id);}

    public ClientInjury update(ClientInjury clientInjury) {
        try {
            clientInjuryRepository.findById(clientInjury.getIdClientInjury());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No exista la alergia en cuestion");
        }

        return clientInjuryRepository.save(clientInjury);
    }


}
