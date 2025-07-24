package com.example.football.entities.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "commission_rate", nullable = false)
    private Double commissionRate;

    @Column(nullable = false)
    private Integer balance;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;
}
