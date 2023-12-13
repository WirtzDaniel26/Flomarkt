package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
