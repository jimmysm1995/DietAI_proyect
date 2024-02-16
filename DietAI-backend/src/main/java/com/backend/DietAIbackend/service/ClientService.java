package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
}
