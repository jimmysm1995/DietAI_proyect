package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class DietAllergyDto {

    private Long idDietAllergy;

    private DietDto diet;

    private AllergyDto allergy;
}
