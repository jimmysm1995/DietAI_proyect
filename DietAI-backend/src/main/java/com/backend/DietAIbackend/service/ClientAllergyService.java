package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.ClientAllergy;
import com.backend.DietAIbackend.repository.AllergyRepository;
import com.backend.DietAIbackend.repository.ClientAllergyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAllergyService {

    @Autowired
    ClientAllergyRepository clientAllergyRepository;

    public ClientAllergy save(Client client, Allergy allergy){

        ClientAllergy clientAllergy = new ClientAllergy();

        clientAllergy.setClient(client);
        clientAllergy.setAllergy(allergy);

        return clientAllergyRepository.save(clientAllergy);
    }

    public ClientAllergy findById(Long id){
        return clientAllergyRepository.findById(id).orElse(null);
    }

    public List<ClientAllergy> findAll(){return clientAllergyRepository.findAll();}
    public void delete(ClientAllergy clientAllergy){ clientAllergyRepository.delete(clientAllergy);}

    public void deleteById(Long id){ clientAllergyRepository.deleteById(id);}

    public ClientAllergy update(ClientAllergy clientAllergy) {
        try {
            clientAllergyRepository.findById(clientAllergy.getIdClientAllergy());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No exista la alergia en cuestion");
        }

        return clientAllergyRepository.save(clientAllergy);
    }
}
