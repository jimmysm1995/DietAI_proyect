package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:4200/"})
@Slf4j
public class UsuarioController {

    @Autowired
    private UserService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        log.info(user.getName());
        log.info(user.getUserName());
        log.info(user.getEmail());
        log.info(user.getPass());


        if (usuarioService.findUserByName(user.getName()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        if (usuarioService.findUserByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email is already registered");
        }

        usuarioService.registerUser(user);

        return ResponseEntity.ok().body(Map.of("message", "User registered successfully"));
    }
}
