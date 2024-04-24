package com.backend.DietAIbackend.config;

import com.backend.DietAIbackend.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    Logger log = LoggerFactory.getLogger(UserDetailsServiceImp.class);

    private final UserServiceImp userService;

    public UserDetailsServiceImp(UserServiceImp userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.debug("loadUserByUsername {}", username);

        return this.userService.findByUsername(username);
    }
}
