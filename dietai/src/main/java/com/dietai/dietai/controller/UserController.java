package com.dietai.dietai.controller;


import com.dietai.dietai.dto.UserDto;
import com.dietai.dietai.mapper.UserMapper;
import com.dietai.dietai.model.User;
import com.dietai.dietai.repository.UserRepository;
import com.dietai.dietai.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {

    @Autowired
    private UserService usuarioService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public String hello(){
        return "hola mundo";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto user) {

        userRepository.findByUsername(user.getUsername()).ifPresent(usuario -> {
            throw new RuntimeException("Username already exists");
        });

        userRepository.findByEmail(user.getEmail()).ifPresent(usuario -> {
            throw new RuntimeException("Email already exists");
        });

        User userModel = userMapper.dtoToModel(user);

//        String hashedPassword = passwordEncoder.encode(user.getPass());
//        userModel.setPassword(hashedPassword);

        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper
                .modelToDto(usuarioService.registerUser(userModel)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto user) {

        User userModel = userMapper.dtoToModel(user);

        try {
            // Buscar usuario por correo electrónico
            Optional<User> foundUserOptional = usuarioService.findByUsername(userModel.getUsername());
            if (foundUserOptional.isPresent()) {
                User foundUser = foundUserOptional.get();
                if (foundUser.getPassword().equals(user.getPass())) {
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
