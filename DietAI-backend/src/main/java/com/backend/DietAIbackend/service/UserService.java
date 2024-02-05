package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

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

    public Optional<User> loginUser(String username, String pass) {
        return userRepository.findByUserNameAndPass(username, pass);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional findUserByName(String name){
        return userRepository.findByName(name);
    }
}
