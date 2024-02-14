package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.RecipeDto;
import com.backend.DietAIbackend.model.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    RecipeDto modelToDto(Recipe recipe);

    Recipe dtoToModel(RecipeDto recipeDto);
}
