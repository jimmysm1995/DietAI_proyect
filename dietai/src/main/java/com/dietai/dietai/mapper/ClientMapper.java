package com.dietai.dietai.mapper;

import com.dietai.dietai.dto.ClientDto;
import com.dietai.dietai.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto modelToDto(Client client);

    Client dtoToModel(ClientDto clientDto);
}
