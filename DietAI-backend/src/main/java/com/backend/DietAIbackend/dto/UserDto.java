package com.backend.DietAIbackend.dto;

import com.backend.DietAIbackend.model.UserAuthority;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    @Schema(example = "1", description = "Id de el usuario")
    private Long idUser;

    @Schema(example = "username", description = "Username de el usuario")
    private String username;

    @Schema(example = "email", description = "Email del usuario")
    private String email;

    @Schema(example = "password", description = "Contraseña del usuario")
    private String password;

    @Schema(description = "Datos del cliente con el que esta relacionado")
    private ClientDto client;

    @Schema(example = "foto", description = "Imagen de la foto de perfil el usuario")
    private String img;
}

