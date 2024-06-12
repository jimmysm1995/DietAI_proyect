package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.ClientAllergy;
import com.backend.DietAIbackend.repository.ClientAllergyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAllergyServiceImp implements ClientAllergyService {

    @Autowired
    ClientAllergyRepository clientAllergyRepository;

    /**
     *
     * Guarda la relación entre el cliente y sus alergias
     *
     * @param client
     * @param allergy
     *
     * @return ClientAllergy
     */
    public ClientAllergy save(Client client, Allergy allergy){

        try {
            ClientAllergy clientAllergy = ClientAllergy.builder()
                    .client(client)
                    .allergy(allergy)
                    .build();

            return clientAllergyRepository.save(clientAllergy);
        } catch (Exception e){
            throw e;
        }

    }

    /**
     *
     * Borra todas las relaciones que contenga al cliente
     * @param client
     */
    @Override
    public void deleteAllByClient(Client client) {
        clientAllergyRepository.deleteAllByClient(client);
    }
}
