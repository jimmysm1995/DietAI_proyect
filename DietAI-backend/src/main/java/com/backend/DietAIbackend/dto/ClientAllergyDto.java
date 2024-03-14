package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.Allergy;
import com.backend.DietAIbackend.model.Client;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ClientAllergyDto {

    private Long idClientAllergy;

    private ClientDto client;

    private AllergyDto allergy;
}
