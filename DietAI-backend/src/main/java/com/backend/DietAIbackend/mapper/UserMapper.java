package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper{

    UserDto modelToDto(User user);

    User dtoToModel(UserDto userDto);
}
