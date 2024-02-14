package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.DietDto;
import com.backend.DietAIbackend.model.Diet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DietMapper {

    DietDto modelToDto(Diet diet);

    Diet dtoToModel(DietDto dietDto);
}
