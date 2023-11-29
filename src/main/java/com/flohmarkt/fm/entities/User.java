package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    String name;
    @Column
    String anschrift;
    @Column
    Integer telefonnummer;
    @Column
    String email;
    //@OneToMany // TODO: später fürs speichern erweitern
    //List<Reservierung>reservierungsListe;
}
