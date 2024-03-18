package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.model.UserAuthority;
import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientRepository clientRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User register(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        List <UserAuthority> userAuthorityList = new ArrayList<>();

        userAuthorityList.add(UserAuthority.READ);

        user.setAuthorities(userAuthorityList);

        return userRepository.save(user);
    }

    public User update(User user) {

        try {
            userRepository.findById(user.getId());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el Usuario en cuestion");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public void delete(User user) { userRepository.delete(user); }

    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username){

        return this.userRepository.findByUsername(username).orElse(null);
    }
}
