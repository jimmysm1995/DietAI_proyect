package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.config.JwtTokenProvider;
import com.backend.DietAIbackend.dto.LoginResponse;
import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.mapper.UserMapper;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.UserRepository;
import com.backend.DietAIbackend.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AuthController {

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

    @Value("${app.security.jwt.secret}")
    private String jwtSecret;

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDTO) {

        User userModel = userMapper.dtoToModel(userDTO);

        if (userRepository.findByUsername(userModel.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        if (userRepository.findByEmail(userModel.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                userMapper.modelToDto(userService.register(userModel)));
    }

    @PostMapping("/auth/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody UserDto userDTO) {

        User userModel = userMapper.dtoToModel(userDTO);

        if (userRepository.findByUsername(userModel.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        if (userRepository.findByEmail(userModel.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                userMapper.modelToDto(userService.registerAdmin(userModel)));
    }

    @PostMapping("/auth/login")
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

    @GetMapping("/auth/currentUser")
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
