package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.MuscleDto;
import com.backend.DietAIbackend.dto.RecipeDto;
import com.backend.DietAIbackend.model.Muscle;
import com.backend.DietAIbackend.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(target = "ingredientRecipe", ignore = true)
    @Mapping(target = "recipeDiets", ignore = true)
    RecipeDto modelToDto(Recipe recipe);

    Recipe dtoToModel(RecipeDto recipeDto);

    List<Recipe> listDtoToModel(List<RecipeDto> recipeDtoList);

    List<RecipeDto> listModelToDto(List<Recipe> recipeList);


}
