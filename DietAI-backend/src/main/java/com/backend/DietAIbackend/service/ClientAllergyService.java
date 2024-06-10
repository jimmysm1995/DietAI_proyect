package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.ClientAllergy;

import java.util.List;

public interface ClientAllergyService {
    ClientAllergy save(Client client, Allergy allergy);
    void deleteAllByClient(Client client);
}
