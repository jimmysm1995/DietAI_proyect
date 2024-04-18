package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.DietDto;
import com.backend.DietAIbackend.dto.RecipeDto;
import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DietMapper {

    @Mapping(target = "recipeDiets", ignore = true)
    @Mapping(target = "clients", ignore = true)
    DietDto modelToDto(Diet diet);

    Diet dtoToModel(DietDto dietDto);

    List<Diet> listDtoToModel(List<DietDto> dietDtoList);

    List<DietDto> listModelToDto(List<Diet> dietList);
}
