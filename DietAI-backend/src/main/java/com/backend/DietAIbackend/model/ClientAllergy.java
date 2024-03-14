package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clientAllergy")
public class ClientAllergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientAllergy;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idAllergy")
    private Allergy allergy;
}
