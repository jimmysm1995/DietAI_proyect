package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "allergy")
@Data
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAllergy", columnDefinition = "tinyint")
    private Long idAllergy;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "client_id")
//    private Client client;
}
