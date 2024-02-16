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
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", columnDefinition = "tinyint")
    private Long idUser;

    @Column(name = "username", columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String username;

    @Column(name = "email", columnDefinition = "varchar(100)",nullable = false)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(100)",nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Client client;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private List<UserAuthority> authorities = new ArrayList<>();
//
//    @ElementCollection(fetch = FetchType.LAZY)
//    private Set<String> ips = new HashSet<>();
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities.stream()
//                .map(auth -> new SimpleGrantedAuthority(auth.toString()))
//                .toList();
//    }
//
//    public User(Long idUser, String username, String email, String password) {
//        this.idUser = idUser;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities.add(UserAuthority.READ);
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public Long getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(Long idUser) {
//        this.idUser = idUser;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public void setAuthorities(List<UserAuthority> authorities) {
//        this.authorities = authorities;
//    }
//
//    public Set<String> getIps() {
//        return ips;
//    }
//
//    public void setIps(Set<String> ips) {
//        this.ips = ips;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "idUser=" + idUser +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
