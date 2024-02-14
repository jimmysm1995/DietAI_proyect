package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.InfoClientDto;
import com.dietai.dietai.model.InfoClient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfoClientMapper {

    InfoClientDto modelToDto(InfoClient infoClient);
    InfoClient dtoToModel(InfoClientDto infoClientDto);
}
