package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List <Reservierung>  reservierungsListe = new ArrayList<>();
}
