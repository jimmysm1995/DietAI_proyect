package com.backend.DietAIbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clientInjury")
public class ClientInjury {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientInjury;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idInjury")
    private Injury injury;
}
