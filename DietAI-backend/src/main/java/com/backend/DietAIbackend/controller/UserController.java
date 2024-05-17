package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.exception.ServiceException;
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
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {

        try {
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.findById(userId)));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        try {
            return ResponseEntity.ok().body(userMapper.listModelToDto(userService.findAll()));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){

        try {
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.findByUsername(username)));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }

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
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto){
        try {
            User user = userMapper.dtoToModel(userDto);
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.update(user)));
        }catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }

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

    @PutMapping("/changeAuthorities/{userId}")
    public ResponseEntity<?> changeAuthorities(
            @RequestBody UserDto userDto,
            @PathVariable Long userId){
        try {
            User user = userMapper.dtoToModel(userDto);
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.changeAuthorities(user, userId)));
        } catch (ServiceException e){
            return ResponseEntity.status(e.getHttpStatus())
                    .body(e.getMessage());
        }
    }

}
