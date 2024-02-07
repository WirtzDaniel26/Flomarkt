package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Platz {
    public Platz(Integer platzNummer, Double laenge) {
        this.platzNummer = platzNummer;
        this.laenge = laenge;
    }

    public Platz(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // wrapper
    @Column
    private Integer platzNummer;
    @Column
    private Double laenge;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="reservierungs_id", referencedColumnName = "id")
    private Reservierung reservierung;
}
