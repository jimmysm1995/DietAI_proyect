package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.DietDto;
import com.backend.DietAIbackend.model.Diet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DietMapper {

    @Mapping(target = "recipeDiets", ignore = true)
    @Mapping(target = "clients", ignore = true)
    DietDto modelToDto(Diet diet);

    Diet dtoToModel(DietDto dietDto);
}
