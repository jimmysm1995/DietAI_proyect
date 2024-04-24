package com.backend.DietAIbackend.service;


import com.backend.DietAIbackend.model.*;

import java.util.List;

public interface ClientInjuryService {

    List<ClientInjury> findAll();
    ClientInjury findById(Long var1);
    ClientInjury save(Client client, Injury injury);
    void deleteById(Long var1);
    ClientInjury update(ClientInjury var1);
}
