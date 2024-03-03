package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUsername(String username){
        return this.userRepository.findByUsername(username);
    }

    public User registerUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }
}
