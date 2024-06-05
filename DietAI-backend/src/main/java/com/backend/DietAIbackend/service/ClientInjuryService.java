package com.backend.DietAIbackend.service;


import com.backend.DietAIbackend.model.*;

import java.util.List;

public interface ClientInjuryService {
    ClientInjury save(Client client, Injury injury);
    void deleteAllByClient(Client client);
}
