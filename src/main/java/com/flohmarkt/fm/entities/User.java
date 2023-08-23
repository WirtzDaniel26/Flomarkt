package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String anschrift;
    Integer telefonnummer;
    String email;
    @OneToMany // TODO: später fürs speichern erweitern
    List<Reservierung>reservierungsListe;
}
