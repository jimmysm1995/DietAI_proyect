package com.dietai.dietai.service;

import com.dietai.dietai.repository.InfoClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoClientService {

    @Autowired
    InfoClientRepository infoClientRepository;
}
