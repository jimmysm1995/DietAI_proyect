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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

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

//76


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDTO) {

        User userModel = userMapper.dtoToModel(userDTO);

        if (userRepository.findByUsername(userModel.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        if (userRepository.findByEmail(userModel.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                userMapper.modelToDto(userService.registerUser(userModel)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        try {
            Authentication authDTO = new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword());

            Authentication authentication = this.authenticationManager.authenticate(authDTO);
            User user = (User) authentication.getPrincipal();

            String token = this.jwtTokenProvider.generetaToken(authentication);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new LoginResponse(user.getUsername(),
                    user.getIdUser(),
                    user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList(),
                    token));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The access has been denied");
        }
    }
}
