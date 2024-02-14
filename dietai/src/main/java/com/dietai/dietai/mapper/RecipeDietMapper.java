package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.RecipeDietDto;
import com.dietai.dietai.model.RecipeDiet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeDietMapper {

    RecipeDietDto modelToDto(RecipeDiet recipeDiet);
    RecipeDiet dtoToModel(RecipeDietDto recipeDietDto);
}
