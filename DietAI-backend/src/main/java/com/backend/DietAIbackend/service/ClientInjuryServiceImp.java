package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.*;
import com.backend.DietAIbackend.repository.ClientInjuryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientInjuryServiceImp implements ClientInjuryService {

    @Autowired
    ClientInjuryRepository clientInjuryRepository;

    /**
     *
     * Guarda la relación entre cliente y sus alergias
     *
     * @param client
     * @param injury
     * @return
     */
    public ClientInjury save(Client client, Injury injury){

        ClientInjury clientInjury = new ClientInjury();

        clientInjury.setClient(client);
        clientInjury.setInjury(injury);

        return clientInjuryRepository.save(clientInjury);
    }

    /**
     *
     * Elimina todas las alergias de un cliente
     *
     * @param client
     */
    @Override
    public void deleteAllByClient(Client client) {
        clientInjuryRepository.deleteAllByClient(client);
    }
}
