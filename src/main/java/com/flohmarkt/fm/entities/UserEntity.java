package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String anschrift;
    @Column(columnDefinition = "INTEGER")
    private Integer telefonnummer;
    @Column
    private String email;
    //@OneToMany // TODO: später fürs speichern erweitern
    //List<Reservierung>reservierungsListe;
}
