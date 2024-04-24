package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.ClientAllergy;

import java.util.List;

public interface ClientAllergyService {

    List<ClientAllergy> findAll();
    ClientAllergy findById(Long var1);
    ClientAllergy save(Client client, Allergy allergy);
    void deleteById(Long var1);
    ClientAllergy update(ClientAllergy var1);
}
