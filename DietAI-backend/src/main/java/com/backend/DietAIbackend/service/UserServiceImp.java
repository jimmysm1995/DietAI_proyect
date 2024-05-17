package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.model.UserAuthority;
import com.backend.DietAIbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<User> findAll() {
        if (userRepository.findAll().isEmpty()){
            throw new ServiceException("No se han encontrado usuarios", HttpStatus.NOT_FOUND.value());
        }
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ServiceException("No se ha encontrado el usuario", HttpStatus.NOT_FOUND.value()));
    }

    @Override
    public User save(User var1) {
        return null;
    }

    @Override
    public User register(User user, boolean isAdmin){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User registerUser = new User(user.getUsername(), user.getEmail(), user.getPassword() ,isAdmin);
            return userRepository.save(registerUser);
        } catch (ServiceException e) {
            throw new ServiceException("El usuario ya existe", HttpStatus.CONFLICT.value());
        }
    }
    public User update(User user) {
        try {
            userRepository.findById(user.getIdUser());
        } catch (ServiceException e){
            throw new ServiceException("No existe el Usuario en cuestion", HttpStatus.NOT_FOUND.value());
        }

        List<User> userList = userRepository.findAll();

        userList.forEach(usuario -> {
            if (usuario.getUsername().equals(user.getUsername()) && (!usuario.getIdUser().equals(user.getIdUser()))){
                throw new ServiceException("Ya existe un usuario con ese nombre", HttpStatus.CONFLICT.value());
            }
        });

        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username){

        return this.userRepository.findByUsername(username).orElseThrow(
                () -> new ServiceException("No se ha encontrado el usuario", HttpStatus.NOT_FOUND.value()));
    }

    @Override
    public List<String> getAuthorities(Long userId) {

        User user = findById(userId);

        return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    }

    @Override
    public User changeAuthorities(User user, Long userId) {

        if (!user.getAuthorities().contains(UserAuthority.ADMIN)){
            throw new ServiceException("El usuario no tiene los permisos para esta solicitud", HttpStatus.BAD_REQUEST.value());
        }

        User changeUser = findById(userId);
        List<UserAuthority> userAuthorityList = new ArrayList<>();
        userAuthorityList.add(UserAuthority.ADMIN);
        changeUser.setAuthorities(userAuthorityList);
        return save(changeUser);
    }

}
