package com.dietai.dietai.mapper;


import com.dietai.dietai.dto.UserDto;
import com.dietai.dietai.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper{

    UserDto modelToDto(User user);

    User dtoToModel(UserDto userDto);
}
