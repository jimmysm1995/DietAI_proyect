package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.mapper.UserMapper;
import com.backend.DietAIbackend.mapper.ClientMapper;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClientMapper clientMapper;


    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {

        return ResponseEntity.ok().body(userMapper.modelToDto(userService.findById(userId)));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){

        return ResponseEntity.ok().body(userMapper.listModelToDto(userService.findAll()));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username){

        return ResponseEntity.ok().body(userMapper.modelToDto(userService.findByUsername(username)));

    }

    @GetMapping("/imagen/{username}")
    public ResponseEntity<String> obtenerImagen(@PathVariable String username) {

        User user = userService.findByUsername(username);

        String imagen = user.getImg();

        return ResponseEntity.ok().body(imagen);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateImagenUser(@PathVariable Long userId, @RequestBody UserDto userDto) {

        User user = userMapper.dtoToModel(userDto);

        // Verifica si el usuario que se está actualizando es el mismo que se proporciona en el cuerpo de la solicitud
        if (user.getIdUser() == null || !user.getIdUser().equals(userId)) {
            throw new IllegalArgumentException("User ID in path variable must match user ID in request body");
        }

        User realUser = userService.findById(userId);

        realUser.setImg(user.getImg());

        // Realiza la actualización del usuario en la base de datos

        return ResponseEntity.ok().body(userMapper.modelToDto(userService.update(realUser)));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        User user = userMapper.dtoToModel(userDto);

        return ResponseEntity.ok().body(userMapper.modelToDto(userService.update(user)));
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long userId){

        userService.deleteById(userId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAuthorities/{userId}")
    public ResponseEntity<List<String>> getAuthorities(@PathVariable Long userId){

        return ResponseEntity.ok().body(userService.getAuthorities(userId));

    }

}
