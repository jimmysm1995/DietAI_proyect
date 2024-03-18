package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class AllergyDto {

    private Long id;

    private String name;

    private List<ClientAllergyDto> clientAllergy;
}
