package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.RecipeDto;
import com.dietai.dietai.model.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    RecipeDto modelToDto(Recipe recipe);

    Recipe dtoToModel(RecipeDto recipeDto);
}
