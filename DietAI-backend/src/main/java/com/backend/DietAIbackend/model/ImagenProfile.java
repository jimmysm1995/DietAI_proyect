package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "imagen_profile")
@Data
public class ImagenProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImagen", columnDefinition = "tinyint")
    private Long idImagen;

    @Column(name = "url", columnDefinition = "varchar(255)")
    private String url;
}
