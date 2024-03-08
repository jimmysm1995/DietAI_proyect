package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.repository.ClientRepository;
import com.backend.DietAIbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User registerUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    public User updateUser(User user) {

        try {
            userRepository.findById(user.getIdUser());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el Usuario en cuestion");
        }
        return userRepository.save(user);
    }

    public void deleteUser(User user) { userRepository.delete(user); }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username){

        return this.userRepository.findByUsername(username).orElse(null);
    }

}
