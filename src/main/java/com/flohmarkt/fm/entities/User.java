package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    @Column
    String name;
    @NonNull
    @Column
    String anschrift;
    @NonNull
    @Column
    Integer telefonnummer;
    @NonNull
    @Column
    String email;
    //@OneToMany // TODO: später fürs speichern erweitern
    //List<Reservierung>reservierungsListe;
}
