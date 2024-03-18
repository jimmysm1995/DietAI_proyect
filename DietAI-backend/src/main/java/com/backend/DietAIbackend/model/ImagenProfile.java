package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "imagen_profile")
@Data
public class ImagenProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "tinyint")
    private Long id;

    @Column(name = "url", columnDefinition = "varchar(255)")
    private String url;
}
