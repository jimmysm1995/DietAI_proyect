package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.dto.UserDto;
import com.backend.DietAIbackend.model.Client;
import com.backend.DietAIbackend.model.Diet;
import com.backend.DietAIbackend.model.User;
import com.backend.DietAIbackend.model.UserAuthority;
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

        User registerUser = new User(user.getUsername(), user.getEmail(), user.getPassword() ,false);

        return userRepository.save(registerUser);
    }

    public User registerAdmin(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User registerUser = new User(user.getUsername(), user.getEmail(), user.getPassword(),true);

        return userRepository.save(registerUser);
    }

    public User update(User user) {

        try {
            userRepository.findById(user.getIdUser());
        } catch (EntityNotFoundException e){
            throw new ServiceException("No existe el Usuario en cuestion");
        }

        List<User> userList = userRepository.findAll();

        userList.forEach(usuario -> {
            if (usuario.getUsername().equals(user.getUsername()) && (!usuario.getIdUser().equals(user.getIdUser()))){
                throw new ServiceException("Ya existe un usuario con ese nombre");
            }
        });

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
