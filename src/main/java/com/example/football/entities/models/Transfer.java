package com.example.football.entities.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "transfers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_team_id", nullable = false)
    private Team fromTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_team_id", nullable = false)
    private Team toTeam;

    @Column(name = "transfer_fee", nullable = false)
    private Double transferFee;

    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;

    @Column(name = "transfer_date")
    private Date transferDate;

    public Transfer(Player player, Team fromTeam, Team toTeam, Double transferFee, Integer totalAmount, Date transferDate) {
        this.player = player;
        this.fromTeam = fromTeam;
        this.toTeam = toTeam;
        this.transferFee = transferFee;
        this.totalAmount = totalAmount;
        this.transferDate = transferDate;
    }
}
