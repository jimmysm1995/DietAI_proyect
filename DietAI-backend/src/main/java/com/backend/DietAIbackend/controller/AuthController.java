package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.config.JwtTokenProvider;
import com.backend.DietAIbackend.dto.ClientDto;
import com.backend.DietAIbackend.dto.LoginResponse;
import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.mapper.ClientMapper;
import com.backend.DietAIbackend.mapper.UserMapper;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.UserRepository;
import com.backend.DietAIbackend.service.ClientService;
import com.backend.DietAIbackend.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@CrossOrigin(origins = "${cors.allowed.origin}")
@Tag(name = "AuthController", description = "Endpoint para la autentificación y creación de los usuarios")
@Slf4j
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ClientService clientService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Value("${app.security.jwt.secret}")
    private String jwtSecret;

    @PostMapping("/auth/register")
    @Operation(summary = "Registrar el usuario")
    public ResponseEntity<UserDto> registerUser(@RequestBody User userDTO) {
        try {
//            User userModel = userMapper.dtoToModel(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    userMapper.modelToDto(userService.register(userDTO, false)));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/auth/register/admin")
    @Operation(summary = "Registrar el usuario que sera administrador")
    public ResponseEntity<UserDto> registerAdmin(@RequestBody User userDTO) {
        try {
//            User userModel = userMapper.dtoToModel(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    userMapper.modelToDto(userService.register(userDTO, true)));
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/auth/login")
    @Operation(summary = "Logear el usuario")
    public ResponseEntity<LoginResponse> login(@RequestBody User userDto){
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
            throw new ServiceException("Acceso denegado" ,HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/auth/currentUser")
    @Operation(summary = "Devuelve el usuario que manda el token")
    public ResponseEntity<UserDto> getCurrentUser(@RequestHeader("Authorization") String token){

        try {
            if (StringUtils.hasLength(token) && token.startsWith("Bearer")){
                token = token.substring("Bearer ".length());
            }

            JwtParser validator = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                    .build();

            Claims claims = validator.parseClaimsJws(token).getBody();
            return ResponseEntity.ok().body(userMapper.modelToDto(userService.findById(Long.parseLong(claims.getSubject()))));
        } catch (Exception e){
            throw new ServiceException("Ha habido un problema al buscar el usuario "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/auth/currentClient")
    @Operation(summary = "Devuelve el cliente que manda el token")
    public ResponseEntity<ClientDto> getCurrentClient(@RequestHeader("Authorization") String token){

        if (StringUtils.hasLength(token) && token.startsWith("Bearer")){
            token = token.substring("Bearer ".length());
        }

        JwtParser validator = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build();

        Claims claims = validator.parseClaimsJws(token).getBody();
        claims.getId();
        return ResponseEntity.ok().body(clientMapper.modelToDto(clientService.findCurrentClient(Long.parseLong(claims.getSubject()))));
    }
}
