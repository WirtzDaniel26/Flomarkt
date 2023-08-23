package com.flohmarkt.fm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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
    private Integer platzNummer;
    private Double laenge;
}
