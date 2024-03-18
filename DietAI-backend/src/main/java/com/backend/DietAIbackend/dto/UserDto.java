package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.UserAuthority;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
//    private ClientDto client;
    private String img;
    private List<UserAuthority> authorities;
}

