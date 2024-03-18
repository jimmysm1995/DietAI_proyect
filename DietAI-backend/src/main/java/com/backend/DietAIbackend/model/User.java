package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "user")
@Data
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String username;

    @Column(name = "email", columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(100)",nullable = false)
    private String password;

    @Column(name = "img", columnDefinition = "varchar(255)")
    private String img;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Client client;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<UserAuthority> authorities = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth.toString()))
                .toList();
    }

    public User(){}

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Long getIdUser() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

//    public Client getClient() {
//        return client;
//    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities.add(UserAuthority.READ);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
