package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.UserMapper;
import com.backend.DietAIbackend.mapper.ClientMapper;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "UserController", description = "Endpoint para los usuarios")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClientMapper clientMapper;


    @GetMapping("/{userId}")
    @Operation(summary = "Devuelve un usuario según su id")
    public ResponseEntity<UserDto> findById(@PathVariable Long userId) {
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.findById(userId)));
    }

    @GetMapping
    @Operation(summary = "Devuelve una lista con todos los usuarios")
    public ResponseEntity<List<UserDto>> findAll(){
            return ResponseEntity.ok().body(userMapper.listModelToDto(userService.findAll()));
    }

    @GetMapping("/username/{username}")
    @Operation(summary = "Devuelve un usuario según su id")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username){

            return ResponseEntity.ok().body(userMapper.modelToDto(userService.findByUsername(username)));

    }

    @GetMapping("/imagen/{username}")
    @Operation(summary = "Devuelve la foto de perfil del usuario")
    public ResponseEntity<String> obtenerImagen(@PathVariable String username) {

        User user = userService.findByUsername(username);

        String imagen = user.getImg();

        return ResponseEntity.ok().body(imagen);
    }


    @PutMapping("/{userId}")
    @Operation(summary = "Cambia la foto de perfil del usuario")
    public ResponseEntity<UserDto> updateImagenUser(@PathVariable Long userId, @RequestBody UserDto userDto) {

        User user = userMapper.dtoToModel(userDto);

        return ResponseEntity.ok().body(userMapper.modelToDto(userService.updateImagenUser(user,userId)));
    }

    @PutMapping
    @Operation(summary = "Actualiza el usuario")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto){
            User user = userMapper.dtoToModel(userDto);
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.update(user)));

    }


    @DeleteMapping("/{userId}")
    @Operation(summary = "Elimina el usuario")
    public ResponseEntity<Void> deleteById(@PathVariable Long userId){

        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAuthorities/{userId}")
    @Operation(summary = "Obtiene los permisos del usuario")
    public ResponseEntity<List<String>> getAuthorities(@PathVariable Long userId){
        return ResponseEntity.ok().body(userService.getAuthorities(userId));
    }

    @PutMapping("/changeAuthorities/{userId}")
    @Operation(summary = "Le da permisos de administrador al usuario")
    public ResponseEntity<?> changeAuthorities(
            @RequestBody UserDto userDto,
            @PathVariable Long userId){
            User user = userMapper.dtoToModel(userDto);
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.changeAuthorities(user, userId)));
    }

    @GetMapping("/client/{id}")
    @Operation(summary = "Devuelve el cliente del usuario")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long id){
        log.info("Pasa por aqui");
        return ResponseEntity.ok().body(clientMapper.modelToDto(userService.getClient(id)));
    }
}
