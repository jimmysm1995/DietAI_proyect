package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.repository.ClientInjuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientInjuryService {

    @Autowired
    ClientInjuryRepository clientInjuryRepository;


}
