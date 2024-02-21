package com.flohmarkt.fm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservierung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    LocalDate zeit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user;
    @OneToMany(mappedBy = "reservierung", orphanRemoval = true, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Platz> platzListe = new ArrayList<>();
}
