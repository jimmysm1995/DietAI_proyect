//package com.backend.DietAIbackend.service;
//
//import com.backend.DietAIbackend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsServiceImp implements UserDetailsService {
//    @Autowired
//    private UserRepository repository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("loadUserByUsername");
//
//        return repository.findByUsername(username).orElseThrow(
//                () -> new UsernameNotFoundException("User not found")
//        );
//    }
//}
