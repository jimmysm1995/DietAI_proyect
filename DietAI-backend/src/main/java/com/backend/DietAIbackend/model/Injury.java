package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "injury")
public class Injury {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "Varchar(255)" ,nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "injury")
    private List<ClientInjury> clientInjury;
}
