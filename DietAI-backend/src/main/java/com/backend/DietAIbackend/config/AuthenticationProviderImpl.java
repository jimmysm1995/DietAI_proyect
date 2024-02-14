package com.backend.DietAIbackend.config;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class AuthenticationProviderImpl implements AuthenticationProvider {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Override
//    public Authentication authenticate(Authentication authentication)
//            throws AuthenticationException {
//
//        String username = authentication.getName();
//        String rawPassword = authentication.getCredentials().toString();
//
//        UserDetails user = userDetailsService.loadUserByUsername(username);
//        String password = user.getPassword();
//
//        if (!isValidPassword(rawPassword, password))
//            throw new BadCredentialsException("");
//
//        return new UsernamePasswordAuthenticationToken(
//                user.getUsername(),
//                user.getPassword(),
//                user.getAuthorities());
//    }
//
//    private boolean isValidPassword(String rawPassword, String password) {
//        return passwordEncoder.matches(rawPassword,password);
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
