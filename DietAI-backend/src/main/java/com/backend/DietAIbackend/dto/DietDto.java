package com.backend.DietAIbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class DietDto {

    private Long id;

    private String name;

    private Integer calorias;

    private List<RecipeDietDto> recipeDiets;

    private List<ClientDto> clients;
}
