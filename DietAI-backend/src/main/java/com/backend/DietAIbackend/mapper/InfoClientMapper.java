package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.InfoClientDto;
import com.backend.DietAIbackend.model.InfoClient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfoClientMapper {

    InfoClientDto modelToDto(InfoClient infoClient);
    InfoClient dtoToModel(InfoClientDto infoClientDto);
}
