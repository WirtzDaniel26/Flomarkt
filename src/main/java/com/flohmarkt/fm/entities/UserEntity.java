package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column
    private String name;
    @NonNull
    @Column
    private String anschrift;
    @Column(columnDefinition = "INTEGER")
    @NonNull
    private Integer telefonnummer;
    @NonNull
    @Column
    private String email;
    //@OneToMany // TODO: später fürs speichern erweitern
    //List<Reservierung>reservierungsListe;
}
