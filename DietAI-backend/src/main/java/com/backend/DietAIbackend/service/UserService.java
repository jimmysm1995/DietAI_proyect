package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.User;

import java.util.List;

public interface UserService extends ICrudService<User, Long>{
    User registerAdmin(User user);
    User findByUsername(String username);

    List<String> getAuthorities(Long userId);
}
