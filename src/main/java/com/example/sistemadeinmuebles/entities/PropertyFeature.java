package com.example.sistemadeinmuebles.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "properties_features")
public class PropertyFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idProperty")
    private Property property;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idFeature")
    private Feature feature;

    @Column(nullable = true)
    private int calification;

    @Column(nullable = true)
    private int classification;

    @Column(nullable = true)
    private Long clics;

    @Column(nullable = true)
    private boolean favorite;

    @Column(nullable = true)
    private String comment;


}
