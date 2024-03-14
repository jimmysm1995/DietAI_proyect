package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Quotes")
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuotes", columnDefinition = "tinyint")
    private Long idQuotes;

    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;
}
