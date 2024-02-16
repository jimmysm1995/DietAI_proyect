package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.mapper.UserMapper;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.model.UserAuthority;
import com.backend.DietAIbackend.repository.UserRepository;
import com.backend.DietAIbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {

    @Autowired
    private UserService usuarioService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hola mundo";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto user) {

        User userModel = userMapper.dtoToModel(user);

        if (userRepository.findByUsername(userModel.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        if (userRepository.findByEmail(userModel.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }


        log.info(userModel.getUsername());
        log.info(userModel.getPassword());

        String hashedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(hashedPassword);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                userMapper.modelToDto(usuarioService.registerUser(userModel)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto user) {

        User userModel = userMapper.dtoToModel(user);

        log.info(userModel.getUsername());
        log.info(userModel.getPassword());

        try {
            // Buscar usuario por correo electrónico
            Optional<User> foundUserOptional = usuarioService.findByUsername(userModel.getUsername());
            if (foundUserOptional.isPresent()) {
                User foundUser = foundUserOptional.get();
                if (passwordEncoder.matches(userModel.getPassword(), foundUser.getPassword())) {
                    // La contraseña coincide, autenticación exitosa
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body((foundUserOptional));
                } else {
                    // La contraseña no coincide
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
                }
            } else {
                // Usuario no encontrado
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
            }
        } catch (Exception e) {
            log.error("Error al intentar autenticar al usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor al intentar autenticar al usuario");
        }
    }
}
