package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.model.Injury;

import java.util.List;

public interface ClientService extends ICrudService <Client, Long>{
    Client save(Client client, List<Allergy> allergyList, List<Injury> injuryList);
    Client asignarDieta(Client client);
    Client asignarEntrenamiento(Client client);
    Client findCurrentClient(long userId);
    Diet getDietByUser(Client client);
}
