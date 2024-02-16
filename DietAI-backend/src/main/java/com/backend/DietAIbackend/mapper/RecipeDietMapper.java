package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.RecipeDietDto;
import com.backend.DietAIbackend.model.RecipeDiet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeDietMapper {

    RecipeDietDto modelToDto(RecipeDiet recipeDiet);
    RecipeDiet dtoToModel(RecipeDietDto recipeDietDto);
}
