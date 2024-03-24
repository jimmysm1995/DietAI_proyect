package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.AllergyDto;
import com.backend.DietAIbackend.model.Allergy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllergyMapper {

    @Mapping(target = "clientAllergy", ignore = true)
    AllergyDto modelToDto(Allergy allergy);

    Allergy dtoToModel(AllergyDto allergyDto);

    List<Allergy> listDtoToModel(List<AllergyDto> allergyDtoList);

    List<AllergyDto> listModelToDto(List<Allergy> allergyList);
}
