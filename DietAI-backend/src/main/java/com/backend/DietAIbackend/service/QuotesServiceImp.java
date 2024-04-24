package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.Quotes;
import com.backend.DietAIbackend.repository.QuotesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class QuotesServiceImp implements QuotesService {

    @Autowired
    QuotesRepository quotesRepository;

    public Quotes getRandomQuote(){

        List<Quotes> listQuotes = quotesRepository.findAll();

        int totalQuotes = listQuotes.size();

        if(totalQuotes == 0) {
            return null; // No hay citas disponibles
        }

        Random random = new Random();
        int randomIndex = random.nextInt(totalQuotes);

        return listQuotes.get(randomIndex);

    }
}
