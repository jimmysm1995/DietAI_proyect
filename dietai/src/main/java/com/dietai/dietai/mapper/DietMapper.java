package com.dietai.dietai.mapper;

import com.dietai.dietai.dto.DietDto;
import com.dietai.dietai.model.Diet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DietMapper {

    DietDto modelToDto(Diet diet);

    Diet dtoToModel(DietDto dietDto);
}
