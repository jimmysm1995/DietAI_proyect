package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.config.JwtTokenProvider;
//import com.backend.DietAIbackend.dto.LoginRequest;
import com.backend.DietAIbackend.dto.LoginResponse;
import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.mapper.UserMapper;
import com.backend.DietAIbackend.mapper.ClientMapper;
import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.UserRepository;
import com.backend.DietAIbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {
    @Value("${app.security.jwt.secret}")
    private String jwtSecret;
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

        List<User> userList = userService.findAll();
        List<UserDto> userDtoList = userMapper.listModelToDto(userList);
        return ResponseEntity.ok().body(userDtoList);
    }

    @GetMapping("/username/{username}")
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
        return userService.update(realUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteByID(@PathVariable Long userId){
        userService.deleteByID(userId);
    }

    @GetMapping("/currentUser")
    public ResponseEntity<UserDto> getCurrentUser(@RequestHeader("Authorization") String token){

        if (StringUtils.hasLength(token) && token.startsWith("Bearer")){
            token = token.substring("Bearer ".length());
        }

        JwtParser validator = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build();

        Claims claims = validator.parseClaimsJws(token).getBody();
        claims.getId();
        return ResponseEntity.ok().body(userMapper.modelToDto(userService.findById(Long.parseLong(claims.getSubject()))));
    }


}
