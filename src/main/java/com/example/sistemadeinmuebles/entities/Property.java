package com.example.sistemadeinmuebles.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")
@Getter
@Setter
@Builder
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private int stratum;

    @Column(nullable = true )
    private int rooms;

    @Column(nullable = true)
    private int bathrooms;

    @Column(nullable = true)
    private int parkingLot;

    @Column(nullable = true)
    private String antiquity;

    @Column(nullable = true)
    private String priceM2;

    @Column(nullable = false)
    private String url;

    @Column(nullable = true)
    private String areaPrivate;

    @Column(nullable = true)
    private String areaBuild;

    @Column(nullable = true)
    private Long administrationPrice;

    @Column(nullable = true)
    private Long price;

    @Column(nullable = true)
    private String state;

    @Column(nullable = true)
    private BigDecimal latitude;

    @Column(nullable = true)
    private BigDecimal length;

    @Column(nullable = true)
    private Float rent;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private City city;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Sector sector;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PropertyType propertyType;

    @OneToMany(mappedBy = "properties")
    private Set<PropertyFeature> propertyFeatures;

    @JoinTable(
            name = "properties_features",
            joinColumns = @JoinColumn(name = "idProperty", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "idFeature", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Feature> features;
}
