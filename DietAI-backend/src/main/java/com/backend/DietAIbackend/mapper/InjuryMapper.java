package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.InjuryDto;
import com.backend.DietAIbackend.model.Injury;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InjuryMapper {

    @Mapping(target = "clientInjury", ignore = true)
    InjuryDto modelToDto(Injury injury);

    Injury dtoToModel(InjuryDto injuryDto);

    List<Injury> listDtoToModel(List<InjuryDto> injuryDtoList);

    List<InjuryDto> listModelToDto(List<Injury> injuryList);
}
