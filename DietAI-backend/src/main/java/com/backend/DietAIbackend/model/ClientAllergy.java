package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "clientAllergy")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
