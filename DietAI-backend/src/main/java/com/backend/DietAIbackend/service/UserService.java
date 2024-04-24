package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.User;

public interface UserService extends ICrudService<User, Long>{
    public User registerAdmin(User user);
    public User findByUsername(String username);
}
