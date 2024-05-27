package com.example.sistemadeinmuebles.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "interests")
@Getter
@Setter
@Builder
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JoinTable(
            name = "interests_users",
            joinColumns = @JoinColumn(name = "idInterest", nullable = false),
            inverseJoinColumns = @JoinColumn(name="idUser", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> user;
}

