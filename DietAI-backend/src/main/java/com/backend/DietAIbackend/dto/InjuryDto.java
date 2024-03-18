package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.ClientInjury;
import lombok.Data;

import java.util.List;

@Data
public class InjuryDto {

    private Long id;
    private String name;

    private List<ClientInjuryDto> clientInjury;

}
