package com.backend.DietAIbackend.config;

import com.backend.DietAIbackend.exception.ServiceException;
import com.backend.DietAIbackend.service.UserService;
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

    private final UserService userService;

    public UserDetailsServiceImp(UserServiceImp userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            log.debug("loadUserByUsername {}", username);
            return this.userService.findByUsername(username);
        } catch (ServiceException e){
            throw new UsernameNotFoundException("No se encuentra en la base de datos");
        }

    }
}
