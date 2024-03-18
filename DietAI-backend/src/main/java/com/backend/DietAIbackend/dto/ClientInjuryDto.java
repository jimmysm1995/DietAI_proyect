package com.backend.DietAIbackend.dto;

import lombok.Data;

@Data
public class ClientInjuryDto {

    private Long id;

    private ClientDto client;

    private InjuryDto injury;


}
