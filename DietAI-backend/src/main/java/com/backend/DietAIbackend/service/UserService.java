package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.User;

import java.util.List;

public interface UserService extends ICrudService<User, Long>{
    User register(User user, boolean isAdmin);
    User findByUsername(String username);

    List<String> getAuthorities(Long userId);

    User updateImagenUser(User user, Long id);

    User changeAuthorities(User user, Long userId);

    User findByUsernameOrEmail(String username, String email);
}
