package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.config.JwtTokenProvider;
//import com.backend.DietAIbackend.dto.LoginRequest;
import com.backend.DietAIbackend.dto.LoginResponse;
import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.mapper.UserMapper;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.UserRepository;
import com.backend.DietAIbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {

        return ResponseEntity.ok().body(userMapper.modelToDto(userService.findById(userId)));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username){

        return ResponseEntity.ok().body(userMapper.modelToDto(userService.findByUsername(username)));

    }

    @GetMapping("/imagen/{username}")
    public String obtenerImagen(@PathVariable String username) {

        User user = userService.findByUsername(username);

        String imagen = user.getImg();

        return imagen;
    }


    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {

        // Verifica si el usuario que se está actualizando es el mismo que se proporciona en el cuerpo de la solicitud
        if (user.getIdUser() == null || !user.getIdUser().equals(userId)) {
            throw new IllegalArgumentException("User ID in path variable must match user ID in request body");
        }

        User realUser = userService.findById(userId);

        realUser.setImg(user.getImg());

        // Realiza la actualización del usuario en la base de datos
        return userService.updateUser(realUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }
}
