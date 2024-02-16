package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.repository.InfoClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoClientService {

    @Autowired
    InfoClientRepository infoClientRepository;
}
