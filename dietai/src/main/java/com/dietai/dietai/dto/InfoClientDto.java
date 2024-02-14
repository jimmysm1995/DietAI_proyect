package com.dietai.dietai.dto;

import com.dietai.dietai.model.Goal;
import lombok.Data;

@Data
public class InfoClientDto {

    private Float weight;

    private Float height;

    private Goal goal;

    private ClientDto client;
}
