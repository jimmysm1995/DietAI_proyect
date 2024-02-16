package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Goal;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class InfoClientDto {

    private Float weight;

    private Float height;

    private Goal goal;

    private ClientDto client;
}
