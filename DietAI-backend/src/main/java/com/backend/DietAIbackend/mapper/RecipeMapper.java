package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.RecipeDto;
import com.backend.DietAIbackend.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(target = "ingredientRecipe", ignore = true)
    RecipeDto modelToDto(Recipe recipe);

    Recipe dtoToModel(RecipeDto recipeDto);
}
