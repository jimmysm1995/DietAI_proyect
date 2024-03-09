package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.IngredientDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    Ingredient dtoToModel(IngredientDto ingredientDto);

    @Mapping(target = "ingredientRecipe", ignore = true)
    IngredientDto modelToDto(Ingredient ingredient);

    List<IngredientDto> listModelToDto(List<Ingredient> ingredientList);
}
