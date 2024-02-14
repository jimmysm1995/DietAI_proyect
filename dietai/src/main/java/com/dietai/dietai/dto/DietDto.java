package com.dietai.dietai.dto;

import lombok.Data;

import java.util.List;

@Data
public class DietDto {

    private String name;

    private Integer calorias;

    private List<RecipeDietDto> recipeDiets;

    private List<ClientDto> clients;
}
