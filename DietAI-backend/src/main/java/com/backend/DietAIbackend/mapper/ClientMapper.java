package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "diet", ignore = true)
    @Mapping(target = "training", ignore = true)
    ClientDto modelToDto(Client client);

    Client dtoToModel(ClientDto clientDto);

    List<Client> listDtoToModel(List<ClientDto> clientDtoList);

    List<ClientDto> listModelToDto(List<Client> clientList);
}
