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
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {

        try {
            Optional<User> user = userService.getUserById(userId);

            if (user.isPresent()){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                        userMapper.modelToDto(user.get())
                );
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There was an error");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error.");
        }
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

        String hashedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(hashedPassword);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                userMapper.modelToDto(userService.registerUser(userModel)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto user) {

        User userModel = userMapper.dtoToModel(user);


        try {
            // Buscar usuario por correo electrónico
            Optional<User> foundUserOptional = userService.findByUsername(userModel.getUsername());
            if (foundUserOptional.isPresent()) {
                User foundUser = foundUserOptional.get();
                if (passwordEncoder.matches(userModel.getPassword(), foundUser.getPassword())) {
                    // La contraseña coincide, autenticación exitosa
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body((foundUserOptional));
                } else {
                    // La contraseña no coincide
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The access has been denied");
                }
            } else {
                // Usuario no encontrado
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The access has been denied");
            }
        } catch (Exception e) {
            log.error("Error al intentar autenticar al usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The access has been denied");
        }
    }
}
