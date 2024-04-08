package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.MuscleDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Muscle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MuscleMapper {

    @Mapping(target = "exerciseMuscles", ignore = true)
    MuscleDto modelToDto(Muscle muscle);

    Muscle dtoToModel(MuscleDto muscleDto);

    List<Muscle> listDtoToModel(List<MuscleDto> muscleDtoList);

    List<MuscleDto> listModelToDto(List<Muscle> muscleList);
}
