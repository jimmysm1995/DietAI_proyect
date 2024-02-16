package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto modelToDto(Client client);

    Client dtoToModel(ClientDto clientDto);
}
