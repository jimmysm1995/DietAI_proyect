package com.backend.DietAIbackend.mapper;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper{

    @Mapping(target = "client", ignore = true)
    UserDto modelToDto(User user);

    User dtoToModel(UserDto userDto);

    List<UserDto> listModelToDto(List<User> userList);

    List<User> listDtoToModel(List<UserDto> userDtoList);
}
