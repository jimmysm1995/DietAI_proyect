package com.backend.DietAIbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long idUser;
    private String username;
    private String email;
    private String password;
    private ClientDto client;
    private String img;
}

