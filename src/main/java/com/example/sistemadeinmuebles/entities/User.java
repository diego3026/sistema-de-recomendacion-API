package com.example.sistemadeinmuebles.entities;

import jakarta.persistence.*;
import lombok.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = true)
    private LocalDateTime lastLoginDate;

    @Column(nullable = false)
    private boolean isSuperUser;

    @ManyToMany(mappedBy = "users")
    private List<Interest> interests;

    @OneToMany(mappedBy = "users")
    private Set<PropertyFeature> propertyFeatures;
}
